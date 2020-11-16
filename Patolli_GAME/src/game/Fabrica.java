/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import dominio.Host;
import dominio.Partida;

/**
 *
 * @author alfonsofelix
 */
public class Fabrica {
    private static IPartida partida;
    
    public static IPartida getFachadaPartida(Partida partidaP){
        if(partida==null){
            partida=new FPartida(partidaP);
        }
        return partida;
    }
}
