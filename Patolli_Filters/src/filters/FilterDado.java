/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dominio.Casilla;
import dominio.Ficha;
import dominio.Jugador;
import dominio.Partida;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author alfonsofelix
 */
public class FilterDado extends Filter<Partida, Partida> {

    @Override
    protected void doFilter() {
        Partida partida = input.get();
        Jugador jugadorTurno = partida.getJugadorTurno();

        if (jugadorTurno != null) {
            switch (partida.getCantidadDado()) {
                case 0:
                    if(jugadorTurno.haMetidoFicha()){
                        partida.setCuantasApuestas(1);
                    }else{
                        partida.setCuantasApuestas(partida.getTurnos().size()-1);
                    }
                    partida.setCuantasMueve(0);
                    partida.setCantidadDado(-1);
                    break;
                case 1:
                    if (jugadorTurno.haMetidoFicha()) {
                        
                        boolean restanFichas = false;

                        for (Ficha ficha : jugadorTurno.getFichas()) {
                            if (!ficha.isEnJuego()) {
                                restanFichas = true;
                                break;
                            }
                        }

                        if (!jugadorTurno.getColaFichas().isEmpty()) {
                            Queue<Ficha> colaFichas = jugadorTurno.getColaFichas();
                            LinkedList<Casilla> casillas=partida.getTablero().getCasillas();
                            for (Ficha f : colaFichas) {
                                Casilla casillaActual;
                                for (Casilla casilla : casillas) {
                                    if (casilla.getFicha() != null) {
                                        if (casilla.getFicha().equals(f)) {
                                            casillaActual = casilla;
                                            Iterator<Casilla> cIterator = partida.getTablero().getCasillas().listIterator(casillaActual.getNumero());
                                            if(cIterator.hasNext()){
                                                if(cIterator.next().equals(jugadorTurno.getCasillaPropia())){
                                                    partida.setFichaMovimiento(f);
                                                    
                                                    restanFichas=false;
                                                }
                                            }
                                            
                                            break;
                                        }
                                    }
                                }
                                
                            }

                        }

                        if (restanFichas) {
                            jugadorTurno.setPuedeMeter(true);
                        }
                    }
                    partida.setCuantasMueve(1);
                    break;
                case 2:
                    partida.setCuantasMueve(2);
                    break;
                case 3:
                    partida.setCuantasMueve(3);
                    break;
                case 4:
                    partida.setCuantasMueve(4);
                    break;
                case 5:
                    partida.setCuantasMueve(10);
                    break;
            }
            if (!jugadorTurno.haMetidoFicha()) {
                if (partida.getCantidadDado() > 0 && partida.getCantidadDado() <= 5) {
                    jugadorTurno.setPuedeMeter(true);
                    jugadorTurno.setHaMetidoFicha(true);
                    partida.setJugadorTurno(jugadorTurno);
                }
            }
        }

        output.put(partida);
        output.doChain();
    }

}
