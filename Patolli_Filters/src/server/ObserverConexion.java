/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dominio.Partida;

/**
 *
 * @author Invitado
 */
public interface ObserverConexion {
    public void update(PatolliServer conexion);
    public void updatePartida(Partida partida);
    public int getNumConectados();
}
