package dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alfonsofelix
 */
public class Partida implements Serializable{

    private static final long serialVersionUID = 5528623733435420078L;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorTurno;
    private EstadoPartida estado;
    private int numCasillasAspa;
    private int numFichasJugador;
    private int fondoApuesta;

    public Partida() {
        jugadores=new ArrayList<>();
        this.estado=EstadoPartida.VACIA;
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

    public Jugador getJugadorTurno() {
        return jugadorTurno;
    }

    public void setJugadorTurno(Jugador jugadorTurno) {
        this.jugadorTurno = jugadorTurno;
    }

    public EstadoPartida getEstado() {
        return estado;
    }

    public void setEstado(EstadoPartida estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Partida{" + "estado=" + estado + '}';
    }
}
