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
class PipeImpl<T> implements Pipe<T> {

    private T objeto;
    private Filter filter;

    public PipeImpl(Filter filter) {
        this.filter = filter;
    }

    @Override
    public void put(T objeto) {
        this.objeto = objeto;
    }

    @Override
    public T next() {
        return this.objeto;
    }

    @Override
    public void doChain() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
