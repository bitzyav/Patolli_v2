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
class FilterMovimiento extends Filter<Partida, Partida>{

    public FilterMovimiento(Pipe input, Pipe output) {
        super(input, output);
    }

    @Override
    protected void doFilter(Pipe<Partida> input, Pipe<Partida> output) {
        Partida partida=input.getObjeto();
        
        //Al final
        input.put(partida, new FilterApuesta(input,output));
    }

}
