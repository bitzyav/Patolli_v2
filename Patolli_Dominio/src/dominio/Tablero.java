/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import grafico.CnvTablero;

/**
 *
 * @author Invitado
 */
public class Tablero {
    private Casilla[] casillas;
    private final CnvTablero canvasTablero;

    public Tablero(int numCasillasAspa) {
        this.casillas = new Casilla[(numCasillasAspa*4)+4];
        canvasTablero=new CnvTablero(numCasillasAspa, 40,40, casillas);
    } 
    public Casilla[] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[] casillas) {
        this.casillas = casillas;
    }

    public CnvTablero getCanvasTablero() {
        return canvasTablero;
    }
}
