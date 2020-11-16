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
class FFilter implements IFilter{

    private Pipe<Partida> pipe;

    public FFilter() {
        pipe=new PipeImpl<>();
    }
    
    @Override
    public void enviar(Partida partida) {
        new FilterDado().doChain(pipe);
    }

    @Override
    public Partida recibir() {
        Pipe p=new SinkCliente<Partida>(pipe).recibirPipe();
        return null;
    }
}
