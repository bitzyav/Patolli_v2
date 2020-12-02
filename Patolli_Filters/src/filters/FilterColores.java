/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dominio.Partida;

/**
 *
 * @author Invitado
 */
class FilterColores extends Filter<Partida, Partida>{

    public FilterColores(Pipe<Partida> input, Pipe<Partida> output) {
        super(input, output);
    }

    @Override
    protected void doFilter(Pipe<Partida> input, Pipe<Partida> output) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
