/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alfonsofelix
 */
public class Jugador implements Serializable{
    private static final long serialVersionUID = -3776674854141656300L;
    private byte numJugador;
    private String nombre;
    private int numFrijoles;
    private ColorFicha color;
    private ArrayList<Ficha> fichas;
    private ArrayList<Apuesta> apuestas;
    private CasillaPropia casillaPropia;
    private boolean asignado;

    public Jugador(){
        this.asignado=false;
        this.fichas=new ArrayList<>();
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

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
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

    @Override
    public String toString() {
        return "Jugador{" + "numJugador=" + numJugador + ", asignado=" + asignado + '}';
    }
}
