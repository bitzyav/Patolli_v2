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
public abstract class Filter<I, O> {

    protected Pipe<I> input;
    protected Pipe<O> output;

    public Filter() {
    }

    public void setInput(Pipe<I> input) {
        this.input = input;
    }

    public void setOutput(Pipe<O> output) {
        this.output = output;
    }
    
    protected abstract void doFilter();
}
