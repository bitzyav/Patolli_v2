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
import java.util.LinkedList;
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
            partida.setJugadorTurno(null);
            partida.setCantidadDado(0);
        }

        if (partida.getJugadorTurno() != null && partida.getEstado() == EstadoPartida.INICIADA && partida.getCuantasMueve() > 0) {
            Jugador jugadorTurno = partida.getJugadorTurno();
            LinkedList<Casilla> casillas = partida.getTablero().getCasillas();

            if (jugadorTurno.isMeterFicha()) {
                Casilla casillaPropia = jugadorTurno.getCasillaPropia();
                Queue<Ficha> colaFichas = jugadorTurno.getColaFichas();
                ArrayList<Ficha> fichas = jugadorTurno.getFichas();
                for (Ficha ficha : fichas) {
                    System.out.println(ficha);
                    if (!ficha.isEnJuego()) {
                        ArrayList<Jugador> jugadores = partida.getJugadores();
                        ficha.setEnJuego(true);
                        fichas.set(fichas.indexOf(ficha), ficha);
                        colaFichas.add(ficha);
                        casillaPropia.setFicha(ficha);
                        casillas.set(casillas.indexOf(casillaPropia), casillaPropia);
                        jugadores.set(jugadores.indexOf(jugadorTurno), jugadorTurno);

                        jugadorTurno.setColaFichas(colaFichas);
                        jugadorTurno.setFichas(fichas);
                        partida.getTablero().setCasillas(casillas);
                        partida.setJugadores(jugadores);
                        jugadorTurno.setMeterFicha(false);
                        jugadorTurno.setPuedeMeter(false);
                        jugadorTurno.setHaMetidoFicha(true);
                        partida.setJugadorTurno(jugadorTurno);
                        partida.setCantidadDado(-1);
                        break;
                    }
                }
            } else if (partida.getFichaMovimiento() != null) {

                Ficha ficha = partida.getFichaMovimiento();

                Casilla casillaActual = null;

                for (Casilla casilla : casillas) {
                    if (casilla.getFicha() != null) {
                        if (casilla.getFicha().equals(ficha)) {
                            casillaActual = casilla;
                            System.out.println(casilla);
                            break;
                        }
                    }
                }
                if (casillaActual != null) {
                    int m = partida.getCuantasMueve();
                    int n = casillas.size() - 1;
                    Casilla destino = null;

                    if ((casillaActual.getNumero() + m) <= n) {
                        destino = casillas.get(casillaActual.getNumero() + m);
                    } else {
                        int x = casillaActual.getNumero() + m - casillas.size();
                        destino = casillas.get(x);
                    }

                    if (destino != null) {
                        if (!destino.getClass().getName().contains("Centro")) {
                            if (destino.getFicha() == null) {
                                boolean debeMeter = false;
                                int van = 0;
                                boolean contar = false;
                                Iterator<Casilla> cIterator = partida.getTablero().getCasillas().listIterator(casillaActual.getNumero());

                                while (cIterator.hasNext()) {
                                    Casilla casillaIt = cIterator.next();
                                    if (contar) {
                                        if (casillaIt.equals(ficha.getJugador().getCasillaPropia())) {
                                            debeMeter = true;
                                            break;
                                        }
                                        if (van == partida.getCuantasMueve()) {
                                            break;
                                        }
                                        van++;
                                    } else {
                                        if (casillaIt.equals(casillaActual)) {
                                            contar = true;
                                        }
                                    }

                                    if (!cIterator.hasNext()) {
                                        cIterator = partida.getTablero().getCasillas().listIterator();
                                    }

                                }

                                if (!debeMeter) {
                                    //AQUI VA TODO LO DE LAS DEMAS CASILLAS
                                    casillaActual.setFicha(null);
                                    destino.setFicha(ficha);
                                    casillas.set(casillas.indexOf(casillaActual), casillaActual);
                                    casillas.set(casillas.indexOf(destino), destino);
                                    partida.getTablero().setCasillas(casillas);

                                    if (!destino.getClass().getName().contains("Semicirculo")) {
                                        
                                        if(destino.getClass().getName().contains("Triangulo")){
                                            partida.setCuantasApuestas(2);
                                        }
                                        
                                        partida.setCantidadDado(-1);
                                    }

                                } else {
                                    casillaActual.setFicha(null);
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
                                }
                            } else {
                                partida.setCantidadDado(-1);
                            }
                        } else {
                            if (destino.getFicha() != null) {
                                destino.setFicha(null);
                                ArrayList<Jugador> jugadores = partida.getJugadores();
                                Queue<Jugador> colaTurnos = partida.getTurnos();

                                Ficha fichaEliminada = destino.getFicha();
                                Jugador jugadorFichaEliminada = fichaEliminada.getJugador();
                                ArrayList<Ficha> fichasJugadorEliminadas = jugadorFichaEliminada.getFichas();
                                Queue<Ficha> colaFichasJugadorEliminadas = jugadorFichaEliminada.getColaFichas();
                                fichaEliminada.setEnJuego(false);
                                fichasJugadorEliminadas.remove(fichaEliminada);
                                colaFichasJugadorEliminadas.remove(fichaEliminada);

                                jugadorFichaEliminada.setColaFichas(colaFichasJugadorEliminadas);
                                jugadorFichaEliminada.setFichas(fichasJugadorEliminadas);

                                if (jugadorFichaEliminada.getFichas().isEmpty() && jugadorFichaEliminada.getColaFichas().isEmpty()) {
                                    jugadorFichaEliminada.setPerdio(true);
                                    colaTurnos.remove(jugadorFichaEliminada);
                                }

                                jugadores.set(jugadores.indexOf(jugadorFichaEliminada), jugadorFichaEliminada);

                                partida.setJugadores(jugadores);
                                partida.setTurnos(colaTurnos);

                            }
                            casillaActual.setFicha(null);
                            destino.setFicha(ficha);
                            casillas.set(casillas.indexOf(casillaActual), casillaActual);
                            casillas.set(casillas.indexOf(destino), destino);
                            partida.getTablero().setCasillas(casillas);
                            partida.setCantidadDado(-1);
                        }
                    }
                }

                Queue<Ficha> colaFichas = jugadorTurno.getColaFichas();
                Ficha fichaTurno = colaFichas.poll();
                colaFichas.add(fichaTurno);

                jugadorTurno.setColaFichas(colaFichas);
                partida.setJugadorTurno(jugadorTurno);

            }
        }
        output.put(partida);
        output.doChain();
    }

}
