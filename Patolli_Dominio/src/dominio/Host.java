/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author alfonsofelix
 */
public class Host extends Jugador{
    private Partida partida; 

    public Host(int numFichas) {
        setFichas(new ArrayList<>());
        for (int i = 0; i < numFichas; i++) {
            getFichas().add(new Ficha(this,false));
        }
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}
