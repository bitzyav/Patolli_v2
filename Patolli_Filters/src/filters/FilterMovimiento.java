/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dominio.Casilla;
import dominio.EstadoPartida;
import dominio.Ficha;
import dominio.Jugador;
import dominio.Partida;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author alfonsofelix
 */
public class FilterMovimiento extends Filter<Partida, Partida> {

    @Override
    protected void doFilter() {
        Partida partida = input.get();

        int numConectados = 0;
        for (Jugador jugadore : partida.getJugadores()) {
            if (jugadore.isAsignado()) {
                numConectados++;
            }
            if (jugadore.isAsignado() && jugadore.getColor() == null) {
                partida.setEstado(EstadoPartida.ESPERA);
                partida.setCantidadDado(0);
            }
        }

        if (numConectados <= 1) {
            partida.setEstado(EstadoPartida.ESPERA);
            partida.setCantidadDado(0);
        }

        if (partida.getJugadorTurno() != null && partida.getFichaMovimiento() != null && partida.getCantidadDado() != -1) {
            Ficha ficha = partida.getFichaMovimiento();
            if (ficha.isEnJuego()) {
                for (int i = 0; i < partida.getCuantasMueve(); i++) {
                    Iterator<Casilla> cIterator = partida.getTablero().getCasillas().listIterator();

                    while (cIterator.hasNext()) {
                        Casilla c = cIterator.next();
                        if (c.getFicha() != null) {
                            if (c.getFicha().equals(ficha)) {
                                c.setFicha(null);
                                if (cIterator.hasNext()) {
                                    Casilla casilla = cIterator.next();
                                    if (casilla.equals(partida.getJugadorTurno().getCasillaPropia())) {
                                        casilla.setFicha(null);
                                        ficha.setEnJuego(false);
                                        Jugador jug = partida.getJugadorTurno();
                                        Queue<Ficha> colaFichas = jug.getColaFichas();
                                        ArrayList<Ficha> fichas = jug.getFichas();
                                        ArrayList<Ficha> fichasGanadoras = jug.getFichasGanadoras();

                                        colaFichas.remove(ficha);
                                        fichas.remove(ficha);
                                        fichasGanadoras.add(ficha);

                                        jug.setColaFichas(colaFichas);
                                        jug.setFichas(fichas);
                                        jug.setFichasGanadoras(fichasGanadoras);

                                        ArrayList<Jugador> jugadores = partida.getJugadores();
                                        jugadores.set(jugadores.indexOf(jug), jug);
                                        partida.setJugadores(jugadores);
                                    } else {
                                        casilla.setFicha(ficha);
                                    }
                                } else {
                                    partida.getTablero().getCasillas().getFirst().setFicha(ficha);
                                }
                                break;
                            }
                        }
                    }
                }

            }
            partida.setCantidadDado(-1);
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
