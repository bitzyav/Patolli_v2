/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dominio.Partida;
import filters.Filter;
import filters.Pipe;
import java.util.List;

/**
 *
 * @author alfonsofelix
 */
public class Proxy implements IServidor {

    private Pipe pipeInicial;

    public Proxy(Pipe pipeInicial) {
        this.pipeInicial = pipeInicial;
    }

    @Override
    public void enviar(Partida partida) {
        this.pipeInicial.put(partida);
        this.pipeInicial.doChain();
    }
}
