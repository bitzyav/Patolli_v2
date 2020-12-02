/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dominio.Partida;
import java.util.List;

/**
 *
 * @author alfonsofelix
 */
public class Proxy implements IServidor{
    
    private List<Filter> filters;
    private List<Pipe> pipes;

    public Proxy(List<Filter> filters, List<Pipe> pipes) {
        this.filters=filters;
        this.pipes=pipes;
    }
    
    @Override
    public void enviar(Partida partida) {
        
    }
}
