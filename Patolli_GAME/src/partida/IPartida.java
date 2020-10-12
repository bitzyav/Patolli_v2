package partida;

import dominio.CasillaPropia;
import dominio.Jugador;
import dominio.Partida;
import dominio.Tablero;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Invitado
 */
public interface IPartida {
    public Partida obtenerPartida();
    public void agregarJugador(Jugador jugador);
    public void meterFicha(Jugador jugador);
    public Tablero obtenerTablero();
    public boolean isTableroListo();
}
