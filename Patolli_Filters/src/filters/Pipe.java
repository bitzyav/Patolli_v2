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
public interface Pipe<T>{
    public void put(T objeto);
    public T get();
    public void doChain();
}
