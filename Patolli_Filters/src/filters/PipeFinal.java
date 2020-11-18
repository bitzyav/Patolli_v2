/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

/**
 *
 * @author alfonsofelix
 */
public class PipeFinal<T> implements Pipe<T> {

    private T objeto;
    private Sink<T> sink;

    @Override
    public void put(T objeto, Filter filter) {
        this.objeto=objeto;
        this.sink = new SinkCliente(this);
    }

    @Override
    public T getObjeto() {
        return this.objeto;
    }

}
