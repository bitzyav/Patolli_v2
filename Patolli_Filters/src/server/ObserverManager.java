package server;

import dominio.Partida;

/**
 * Interfaz que define a una clase como observadora sobre el estado de la partida.
 * @author alfonsofelix
 */
public interface ObserverManager {
    public void update(Partida partida);
}
