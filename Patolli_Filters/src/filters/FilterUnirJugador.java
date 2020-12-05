/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dominio.EstadoPartida;
import dominio.Host;
import dominio.Jugador;
import dominio.Partida;
import java.util.List;

/**
 *
 * @author Invitado
 */
public class FilterUnirJugador extends Filter<Partida, Partida>{

    @Override
    protected void doFilter() {
        Partida partida=input.get();
        /*
        List<Jugador> jugadores=partida.getJugadores();
        
        switch(jugadores.size()){
            
        }*/
        
        System.out.println("Entró a Filter Unir Jugador");
        
        if(partida.getJugadores().isEmpty()){
            
        }else{
            partida.setEstado(EstadoPartida.ESPERA);
        }
        
        output.put(partida);
        output.doChain();
    }
    
}
