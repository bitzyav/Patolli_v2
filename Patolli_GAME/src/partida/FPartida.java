/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partida;

import dominio.Host;
import dominio.Jugador;
import dominio.Partida;
import dominio.Tablero;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author Invitado
 */
class FPartida implements IPartida{

    private Host host;
    private Turnos turnos;

    public FPartida(Host host) {
        this.host = host;
        this.turnos=new Turnos();
    }
    
    @Override
    public Partida obtenerPartida() {
        return this.host.getPartida();
    }

    @Override
    public void meterFicha(Jugador jugador) {
        turnos.meterFicha(jugador, obtenerTablero());
    }

    @Override
    public Tablero obtenerTablero() {
        return this.host.getPartida().getTablero();
    }
   
}
