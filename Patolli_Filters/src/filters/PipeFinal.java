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

    public PipeFinal(Sink<T> sink) {
        this.sink=sink;
    }

    @Override
    public void put(T objeto) {
        this.objeto=objeto;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public void doChain() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
