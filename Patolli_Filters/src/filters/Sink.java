/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dominio.Partida;
import server.ObserverManager;

/**
 *
 * @author alfonsofelix
 */
public abstract class Sink<T> {

    protected ObserverManager serverManager;
    protected T partida;

    public Sink(ObserverManager serverManager) {
        this.serverManager = serverManager;
    }

    public T getPartida() {
        return partida;
    }

    public void actualizar(T partida) {
        this.partida = partida;
        System.out.println("Llegó al Sink");
        notificar();
        System.out.println("Notificó");
    }

    protected abstract void notificar();
}
