/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author alfonsofelix
 */
public class CasillaPropia extends Casilla{

    private Jugador jugador;
    
    public CasillaPropia() {
    }

    public CasillaPropia(int coordenadaX, int coordenadaY, int numero) {
        super(coordenadaX, coordenadaY, numero);
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
