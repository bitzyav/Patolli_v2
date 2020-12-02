/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dominio.Jugador;
import dominio.Partida;
import java.util.List;

/**
 *
 * @author Invitado
 */
class FilterUnirJugador extends Filter<Partida, Partida>{

    public FilterUnirJugador(Pipe<Partida> input, Pipe<Partida> output) {
        super(input, output);
    }

    @Override
    protected void doFilter(Pipe<Partida> input, Pipe<Partida> output) {
        Partida partida=input.next();
        
        List<Jugador> jugadores=partida.getJugadores();
        
        switch(jugadores.size()){
            
        }
        
        output.put(partida);
    }
    
}
