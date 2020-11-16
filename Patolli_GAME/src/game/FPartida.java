/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import main.SocketServer;
import dominio.Casilla;
import dominio.CasillaPropia;
import dominio.Host;
import dominio.Jugador;
import dominio.Partida;
import dominio.Tablero;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author alfonsofelix
 */
class FPartida implements IPartida {
    
    private Partida partida;

    public FPartida(Partida partida) {
        this.partida=partida;
    }

    @Override
    public Partida obtenerPartida() {
        return this.partida;
    }

    @Override
    public void meterFicha(Jugador jugador) {
        //turnos.meterFicha(jugador, obtenerTablero());
    }

    @Override
    public Tablero obtenerTablero() {
        return obtenerPartida().getTablero();
    }

}
