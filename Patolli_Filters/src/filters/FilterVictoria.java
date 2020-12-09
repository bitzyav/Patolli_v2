/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dominio.EstadoPartida;
import dominio.Jugador;
import dominio.Partida;
import java.util.Queue;

/**
 *
 * @author Invitado
 */
public class FilterVictoria extends Filter<Partida, Partida> {

    @Override
    protected void doFilter() {
        Partida partida = input.get();

        for (Jugador jug : partida.getJugadores()) {
            if (jug.getNumFrijoles() <= 0 && partida.getTurnos().contains(jug)) {
                Queue<Jugador> turnos = partida.getTurnos();
                turnos.remove(jug);
                partida.setTurnos(turnos);
            }

            if (jug.getFichas().isEmpty() && jug.getColaFichas().isEmpty() && partida.getTurnos().contains(jug)) {
                Queue<Jugador> turnos = partida.getTurnos();
                turnos.remove(jug);
                partida.setTurnos(turnos);
            }

            if (jug.getFichasGanadoras().size() == partida.getNumFichasJugador()) {
                partida.setGanador(jug);
                partida.setEstado(EstadoPartida.TERMINADA);
                break;
            }

        }
        if (partida.getTurnos().isEmpty()) {
            Jugador ganador = partida.getJugadores().get(0);
            for (Jugador jugador : partida.getJugadores()) {
                if (jugador.getFichasGanadoras().size() > ganador.getFichasGanadoras().size()) {
                    ganador = jugador;
                }
            }
            partida.setGanador(ganador);
            partida.setEstado(EstadoPartida.TERMINADA);
        }
        output.put(partida);
        output.doChain();
    }

}
