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

/**
 *
 * @author Invitado
 */
public class FilterConfiguracion extends Filter<Partida, Partida> {

    @Override
    protected void doFilter() {
        Partida partida = input.get();
        if (partida.getJugadores().isEmpty()) {
            Jugador host = new Host();

            host.setNumJugador((byte) 1);

            partida.getJugadores().add(host);

            partida.setEstado(EstadoPartida.CONFIGURACION);
        }

        System.out.println("FondoApuesta: " + partida.getFondoApuesta());
        System.out.println("NumCasillas: " + partida.getNumCasillasAspa());
        System.out.println("NumFichas: " + partida.getNumFichasJugador());
        if (partida.getFondoApuesta() != 0 && partida.getNumCasillasAspa() != 0 && partida.getNumFichasJugador() != 0) {
            Jugador jugador = new Huesped();
            jugador.setNumJugador((byte) (partida.getJugadores().size() + 1));
            partida.getJugadores().add(jugador);
            partida.setEstado(EstadoPartida.ESPERA);
            
        }

        output.put(partida);
        output.doChain();
    }
}
