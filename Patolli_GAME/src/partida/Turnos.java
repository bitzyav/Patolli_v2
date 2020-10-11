/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partida;

import dominio.Ficha;
import dominio.Jugador;
import dominio.Tablero;
import java.util.Queue;

/**
 *
 * @author Invitado
 */
class Turnos{
    private Queue<Jugador> colaTurnos;
    public void meterFicha(Jugador jugador, Tablero tablero) {
        for (Ficha ficha : jugador.getFichas()) {
            if(!ficha.isEnJuego()){
                tablero.getCanvasTablero().dibujarFicha(ficha, ficha.getJugador().getCasillaPropia());
                ficha.getJugador().getCasillaPropia().setFicha(ficha);
            }
        }
    }

    public Queue<Jugador> getColaTurnos() {
        return colaTurnos;
    }

    public void setColaTurnos(Queue<Jugador> colaTurnos) {
        this.colaTurnos = colaTurnos;
    }
}
