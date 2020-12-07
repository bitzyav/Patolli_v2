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
public class FilterMovimiento extends Filter<Partida, Partida> {

    @Override
    protected void doFilter() {
        Partida partida=input.get();
        
        //AQUI VAN ACCIONES
        
        output.put(partida);
        output.doChain();
    }

}
