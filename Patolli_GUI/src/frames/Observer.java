/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import dominio.Partida;

/**
 *
 * @author alfonsofelix
 */
public interface Observer {
    /**
     * Método para notificar al Observador de que ha llegado algo.
     * @param partidaLlegada La partida que llegó.
     */
    public void update(Partida partidaLlegada);
}
