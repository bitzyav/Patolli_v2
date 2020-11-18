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
public class Proxy implements IServidor{

    private Partida partida;

    public Proxy(Partida partida) {
        this.partida=partida;
    }
    
    @Override
    public void enviar(Partida partida) {
        Pipe<Partida> pipe = new PipeImpl<>();
        pipe.put(partida, new FilterDado(pipe, new PipeImpl<>()));
    }
}
