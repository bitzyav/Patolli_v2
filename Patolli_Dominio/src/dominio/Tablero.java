/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author alfonsofelix
 */
public class Tablero implements Serializable{

    private static final long serialVersionUID = -4931699436996681187L;

    private LinkedList<Casilla> casillas;

    public Tablero() {
        casillas = new LinkedList<>();
    }

    public LinkedList<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(LinkedList<Casilla> casillas) {
        this.casillas = casillas;
    }
}
