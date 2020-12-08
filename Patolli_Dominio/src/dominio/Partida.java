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
    private Ficha fichaMovimiento;
    private boolean turnoApuesta;
    private int numCasillasAspa;
    private int numFichasJugador;
    private int fondoApuesta;
    private int valorApuesta;

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

    public int getNumCasillasAspa() {
        return numCasillasAspa;
    }

    public void setNumCasillasAspa(int numCasillasAspa) {
        this.numCasillasAspa = numCasillasAspa;
    }

    public int getNumFichasJugador() {
        return numFichasJugador;
    }

    public void setNumFichasJugador(int numFichasJugador) {
        this.numFichasJugador = numFichasJugador;
    }

    public int getFondoApuesta() {
        return fondoApuesta;
    }

    public void setFondoApuesta(int fondoApuesta) {
        this.fondoApuesta = fondoApuesta;
    }

    public int getValorApuesta() {
        return valorApuesta;
    }

    public void setValorApuesta(int valorApuesta) {
        this.valorApuesta = valorApuesta;
    }

    public Ficha getFichaMovimiento() {
        return fichaMovimiento;
    }

    public void setFichaMovimiento(Ficha fichaMovimiento) {
        this.fichaMovimiento = fichaMovimiento;
    }

    public boolean isTurnoApuesta() {
        return turnoApuesta;
    }

    public void setTurnoApuesta(boolean turnoApuesta) {
        this.turnoApuesta = turnoApuesta;
    }
    
    @Override
    public String toString() {
        return "Partida{" + "estado=" + estado + ", numCasillasAspa=" + numCasillasAspa + ", numFichasJugador=" + numFichasJugador + ", fondoApuesta=" + fondoApuesta + '}';
    }
}
