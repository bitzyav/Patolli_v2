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
abstract class Filter<I, O> {

    protected Pipe<I> input;
    protected Pipe<O> output;

    public Filter(Pipe<I> input, Pipe<O> output) {
        this.input = input;
        this.output = output;
    }

    protected abstract void doFilter(Pipe<I> input, Pipe<O> output);
}
