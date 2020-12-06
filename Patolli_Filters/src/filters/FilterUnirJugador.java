/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dominio.Casilla;
import dominio.CasillaPropia;
import dominio.EstadoPartida;
import dominio.Ficha;
import dominio.Host;
import dominio.Huesped;
import dominio.Jugador;
import dominio.Partida;
import dominio.Tablero;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Invitado
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

        Tablero tablero = partida.getTablero();
        if (tablero != null) {
            ArrayList<Jugador> jugadores = partida.getJugadores();

            for (Jugador jug : jugadores) {
                if (jug.isAsignado() && jug.getColor() != null) {
                    if (jug.getCasillaPropia() == null) {
                        ArrayList<Ficha> fichas=jug.getFichas();
                        for (int i = 0; i < partida.getNumFichasJugador(); i++) {
                            fichas.add(new Ficha(i, jug, true));
                        }
                        jug.setFichas(fichas);
                        LinkedList<Casilla> casillas = partida.getTablero().getCasillas();

                        for (Casilla casilla : casillas) {
                            if (casilla.getClass().getName().contains("CasillaPropia")) {
                                CasillaPropia cas = (CasillaPropia) casilla;
                                if (cas.getJugador() == null) {
                                    cas.setJugador(jug);
                                    jug.setCasillaPropia(cas);
                                    Ficha ficha=jug.getFichas().get(0);
                                    ficha.setJugador(jug);
                                    jug.getFichas().set(0, ficha);
                                    cas.setFicha(jug.getFichas().get(0));
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
            if (!jugador.isAsignado() || jugador.getColor() == null || jugador.getCasillaPropia()==null) {
                listos = false;
                break;
            }
        }
        return listos;
    }
}
