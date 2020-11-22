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
class PipeImpl<T> implements Pipe<T>{
    private T objeto;

    public PipeImpl() {

    }

    @Override
    public void put(T objeto, Filter filter) {
        this.objeto=objeto;
        filter.doFilter(this, new PipeImpl<T>());
    }

    public T getObjeto() {
        return objeto;
    }
}
