/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.awt.geom.Ellipse2D;
import java.io.Serializable;

/**
 *
 * @author alfonsofelix
 */
public class Casilla implements Serializable{

    private static final long serialVersionUID = -7010454262487254551L;
    private int coordenadaX;
    private int coordenadaY;
    private int numero;
    private Ficha ficha;

    public Casilla() {
    }

    public Casilla(int coordenadaX, int coordenadaY, int numero) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.numero=numero;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
