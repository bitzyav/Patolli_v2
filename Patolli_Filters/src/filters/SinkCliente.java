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
public class SinkCliente extends Sink<Partida>{

    public SinkCliente(ObserverManager serverManager) {
        super(serverManager);
    }

    public void actualizar(Partida partida){
        this.partida=partida;
        notificar();
    }
    
    @Override
    protected void notificar() {
        serverManager.update(partida);
    }
    
}
