package dominio;

import java.util.ArrayList;

/**
 *
 * @author alfonsofelix
 */
public class Partida {
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;

    public Partida() {
        jugadores=new ArrayList<>();
    }
    
    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
