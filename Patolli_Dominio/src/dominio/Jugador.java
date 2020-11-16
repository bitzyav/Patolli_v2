/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author alfonsofelix
 */
public class Jugador {
    private byte numJugador;
    private String nombre;
    private int numFrijoles;
    private ColorFicha color;
    private ArrayList<Ficha> fichas;
    private ArrayList<Apuesta> apuestas;
    private CasillaPropia casillaPropia;

    public byte getNumJugador() {
        return numJugador;
    }

    public void setNumJugador(byte numJugador) {
        this.numJugador = numJugador;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumFrijoles() {
        return numFrijoles;
    }

    public void setNumFrijoles(int numFrijoles) {
        this.numFrijoles = numFrijoles;
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public ColorFicha getColor() {
        return color;
    }

    public void setColor(ColorFicha color) {
        this.color = color;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }

    public CasillaPropia getCasillaPropia() {
        return casillaPropia;
    }

    public void setCasillaPropia(CasillaPropia casillaPropia) {
        this.casillaPropia = casillaPropia;
    }
}
