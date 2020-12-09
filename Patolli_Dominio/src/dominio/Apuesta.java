/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;

/**
 *
 * @author alfonsofelix
 */
public class Apuesta implements Serializable{

    private static final long serialVersionUID = -5988478280952761303L;
    private int valor;
    private Ficha ficha;
    private TipoApuesta tipo;

    public Apuesta(TipoApuesta tipo) {
        this.tipo = tipo;
    }
    
    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public TipoApuesta getTipo() {
        return tipo;
    }

    public void setTipo(TipoApuesta tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
