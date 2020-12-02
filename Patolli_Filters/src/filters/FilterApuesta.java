/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dominio.Partida;

/**
 *
 * @author alfonsofelix
 */
class FilterApuesta extends Filter<Partida, Partida>{

    public FilterApuesta(Pipe input, Pipe output) {
        super(input, output);
    }

    @Override
    protected void doFilter(Pipe<Partida> input, Pipe<Partida> output) {
        
    }

}
