/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.awt.geom.Ellipse2D;

/**
 *
 * @author Invitado
 */
public class Casilla {
    private int coordenadaX;
    private int coordenadaY;
    private Ellipse2D dibujoFicha;
    private Ficha ficha;

    public Casilla() {
    }

    public Casilla(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }
    
    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Ellipse2D getDibujoFicha() {
        return dibujoFicha;
    }

    public void setDibujoFicha(Ellipse2D dibujoFicha) {
        this.dibujoFicha = dibujoFicha;
    }
}
