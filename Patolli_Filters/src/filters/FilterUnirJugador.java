package filters;

import dominio.Casilla;
import dominio.CasillaPropia;
import dominio.EstadoPartida;
import dominio.Ficha;
import dominio.Huesped;
import dominio.Jugador;
import dominio.Partida;
import dominio.Tablero;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase encargada de ajustar el estado de la partida para que un jugador se una a la partida.
 * @author alfonsofelix
 */
public class FilterUnirJugador extends Filter<Partida, Partida> {

    @Override
    protected void doFilter() {
        Partida partida = input.get();
        /*
        List<Jugador> jugadores=partida.getJugadores();
        
        switch(jugadores.size()){
            
        }*/

        if (partida.getJugadorTurno() == null) {
            if (partida.getJugadores().size() < 4) {
                Jugador jugador = new Huesped();
                jugador.setNumJugador((byte) (partida.getJugadores().size() + 1));
                partida.getJugadores().add(jugador);

                if (partida.getJugadores().size() == 4 && todosListos(partida)) {
                    partida.setEstado(EstadoPartida.INICIADA);
                }
            }
        }

        for (Jugador jugadore : partida.getJugadores()) {
            if (jugadore.isAsignado()) {
                if (!partida.getTurnos().contains(jugadore)) {
                    partida.getTurnos().add(jugadore);
                }
            }
        }

        Tablero tablero = partida.getTablero();
        if (tablero != null) {
            ArrayList<Jugador> jugadores = partida.getJugadores();

            for (Jugador jug : jugadores) {
                if (jug.isAsignado() && jug.getColor() != null) {
                    if (jug.getCasillaPropia() == null) {
                        ArrayList<Ficha> fichas = jug.getFichas();
                        for (int i = 0; i < partida.getNumFichasJugador(); i++) {
                            fichas.add(new Ficha(i, jug, false));
                        }
                        jug.setFichas(fichas);
                        LinkedList<Casilla> casillas = partida.getTablero().getCasillas();

                        for (Casilla casilla : casillas) {
                            if (casilla.getClass().getName().contains("CasillaPropia")) {
                                CasillaPropia cas = (CasillaPropia) casilla;
                                if (cas.getJugador() == null) {
                                    cas.setJugador(jug);
                                    jug.setCasillaPropia(cas);
                                    jug.setNumFrijoles(partida.getFondoApuesta());
                                    break;
                                }
                            }
                        }
                        tablero.setCasillas(casillas);
                        jugadores.set(jugadores.indexOf(jug), jug);
                        partida.setJugadores(jugadores);
                        partida.setTablero(tablero);
                    }
                }
            }

        }

        partida.setJugadorTurno(null);
        output.put(partida);
        output.doChain();
    }

    private boolean todosListos(Partida partida) {
        boolean listos = true;
        for (Jugador jugador : partida.getJugadores()) {
            if (!jugador.isAsignado() || jugador.getColor() == null || jugador.getCasillaPropia() == null) {
                listos = false;
                break;
            }
        }
        return listos;
    }
}
