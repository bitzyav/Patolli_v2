/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partida;

import dominio.Host;

/**
 *
 * @author Invitado
 */
public class Fabrica {
    private static IPartida partida;
    
    public static IPartida getFachadaPartida(Host host){
        if(partida==null){
            partida=new FPartida(host);
        }
        return partida;
    }
}
