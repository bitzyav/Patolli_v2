package server;

import dominio.Partida;

/**
 * Interfaz que define que una clase es observadora de las conexiones entrantes.
 * @author alfonsofelix
 */
public interface ObserverConexion {
    public void update(PatolliServer conexion);
    public void updatePartida(Partida partida);
    public int getNumConectados();
}
