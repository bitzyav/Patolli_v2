/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dominio.Apuesta;
import dominio.Ficha;
import dominio.Jugador;
import dominio.Partida;
import dominio.TipoApuesta;
import java.util.ArrayList;

/**
 *
 * @author alfonsofelix
 */
public class FilterApuesta extends Filter<Partida, Partida> {

    @Override
    protected void doFilter() {
        Partida partida = input.get();
        
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
                    ArrayList<Jugador> jugadores = partida.getJugadores();
                    jugadores.set(jugadores.indexOf(jugadorTurno), jugadorTurno);

                    partida.setJugadores(jugadores);
                }
            }
        }

        partida.setCuantasApuestas(0);
        partida.setAvanzaPagando(false);

        if (partida.getCantidadDado() == -1) {
            Jugador turno = partida.getTurnos().poll();
            partida.setJugadorTurno(turno);
            partida.getTurnos().add(turno);
        }

        output.put(partida);
        output.doChain();
    }

}
