package dominio;

import java.util.ArrayList;

/**
 *
 * @author alfonsofelix
 */
public class Partida {
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorTurno;
    private EstadoPartida estado;
    private int numCasillasAspa;
    private int numFichasJugador;
    private int fondoApuesta;

    public Partida(int numCasillasAspa, int numFichasJugador, int fondoApuesta) {
        jugadores=new ArrayList<>();
        this.estado=EstadoPartida.ESPERA;
        this.numCasillasAspa=numCasillasAspa;
        this.numFichasJugador=numFichasJugador;
        this.fondoApuesta=fondoApuesta;
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
}
