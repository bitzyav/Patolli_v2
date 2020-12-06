/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author alfonsofelix
 */
public class CasillaSemicirculo extends Casilla{

    private static final long serialVersionUID = 4788848240622610403L;

    private LugarSemicirculo lugar;
    
    public CasillaSemicirculo() {
    }

    public CasillaSemicirculo(int coordenadaX, int coordenadaY, int numero, LugarSemicirculo lugar) {
        super(coordenadaX, coordenadaY, numero);
        this.lugar=lugar;
    }    

    public LugarSemicirculo getLugar() {
        return lugar;
    }
}
