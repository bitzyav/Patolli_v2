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

    public Jugador(){
        
    }
    
    public Jugador(String nombre, ColorFicha color) {
        this.fichas=new ArrayList<>();
        this.apuestas=new ArrayList<>();
        this.nombre = nombre;
        this.color = color;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (this.numJugador != other.numJugador) {
            return false;
        }
        return true;
    }
}
