/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Invitado
 */
public class Ficha {
    private Jugador jugador;
    private boolean enJuego;

    public Ficha(Jugador jugador, boolean enJuego) {
        this.jugador = jugador;
        this.enJuego=enJuego;
    }
    
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean isEnJuego() {
        return enJuego;
    }

    public void setEnJuego(boolean enJuego) {
        this.enJuego = enJuego;
    }
}
