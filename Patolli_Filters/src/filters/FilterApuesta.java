package filters;

import dominio.Apuesta;
import dominio.Ficha;
import dominio.Jugador;
import dominio.Partida;
import dominio.TipoApuesta;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Clase encargada de ajustar el estado de la partida cuando se hace una apuesta.
 * @author alfonsofelix
 */
public class FilterApuesta extends Filter<Partida, Partida> {

    @Override
    protected void doFilter() {
        Partida partida = input.get();
        if (!partida.saliendo()) {
            Jugador jugadorTurno = partida.getJugadorTurno();
            ArrayList<Apuesta> apuestas = jugadorTurno.getApuestas();
            Ficha fichaTurno = partida.getFichaMovimiento();
            if (partida.avanzaPagando()) {
                Apuesta apuesta = new Apuesta(TipoApuesta.VOLUNTARIA);
                if (fichaTurno != null) {
                    apuesta.setFicha(fichaTurno);
                }
                apuesta.setValor(partida.getValorApuesta());
                apuestas.add(apuesta);
                jugadorTurno.setApuestas(apuestas);
                jugadorTurno.setNumFrijoles(jugadorTurno.getNumFrijoles() - partida.getValorApuesta());
                ArrayList<Jugador> jugadores = partida.getJugadores();
                jugadores.set(jugadores.indexOf(jugadorTurno), jugadorTurno);
                partida.setJugadores(jugadores);
            } else {
                ArrayList<Jugador> jugadores = partida.getJugadores();
                Queue<Jugador> turnos = partida.getTurnos();
                if (partida.getCuantasApuestas() > 0) {

                    for (int i = 0; i < partida.getCuantasApuestas(); i++) {
                        Apuesta apuesta = new Apuesta(TipoApuesta.OBLIGATORIA);
                        if (fichaTurno != null) {
                            apuesta.setFicha(fichaTurno);
                        }
                        apuesta.setValor(partida.getValorApuesta());
                        apuestas.add(apuesta);
                        jugadorTurno.setApuestas(apuestas);
                        jugadorTurno.setNumFrijoles(jugadorTurno.getNumFrijoles() - partida.getValorApuesta());
                    }
                    jugadores.set(jugadores.indexOf(jugadorTurno), jugadorTurno);

                    if (partida.pagaTodos()) {
                        for (Jugador turno : turnos) {
                            if (!turno.equals(jugadorTurno)) {
                                turno.setNumFrijoles(turno.getNumFrijoles() + partida.getValorApuesta());
                                jugadores.set(jugadores.indexOf(turno), turno);
                            }
                        }
                    }
                }
                if (partida.recibeTodos()) {
                    for (Jugador turno : turnos) {
                        if (!turno.equals(jugadorTurno)) {
                            jugadorTurno.setNumFrijoles(jugadorTurno.getNumFrijoles() + partida.getValorApuesta());
                            turno.setNumFrijoles(turno.getNumFrijoles() - partida.getValorApuesta());
                            jugadores.set(jugadores.indexOf(turno), turno);

                        }
                    }
                    jugadores.set(jugadores.indexOf(jugadorTurno), jugadorTurno);
                }
                partida.setTurnos(turnos);
                partida.setJugadores(jugadores);
            }

            partida.setRecibeTodos(false);
            partida.setPagaTodos(false);
            partida.setCuantasApuestas(0);
            partida.setAvanzaPagando(false);

        }

        if (partida.getCantidadDado() == -1) {
            Jugador turno = partida.getTurnos().poll();
            partida.setJugadorTurno(turno);
            partida.getTurnos().add(turno);
        }

        output.put(partida);
        output.doChain();
    }

}
