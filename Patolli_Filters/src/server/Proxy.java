/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dominio.Partida;
import filters.Pipe;

/**
 * Clase Proxy para hacer el envío a los filtros.
 * @author alfonsofelix
 */
public class Proxy implements IServidor {

    private Pipe pipeInicial;

    /**
     * Construye la instancia del objeto e inicializa los siguientes valores:
     * @param pipeInicial Pipe por el cuál se empezara a enviar a los filtros.
     */
    public Proxy(Pipe pipeInicial) {
        this.pipeInicial = pipeInicial;
    }

    /**
     * Método para enviar al primer filtro la Partida.
     * @param partida Instancia de la partida a filtrar.
     */
    @Override
    public void enviar(Partida partida) {
        this.pipeInicial.put(partida);
        this.pipeInicial.doChain();
    }
}
