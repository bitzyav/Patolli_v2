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
public class CasillaPropia extends Casilla{

    private Jugador jugador;
    
    public CasillaPropia() {
    }

    public CasillaPropia(int coordenadaX, int coordenadaY) {
        super(coordenadaX, coordenadaY);
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
