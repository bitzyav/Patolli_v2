/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import dominio.Jugador;
import dominio.Partida;
import socketCliente.SocketCliente;

/**
 *
 * @author alfonsofelix
 */
abstract class FrmClienteAux extends FrmBase implements Observer{
    protected SocketCliente cliente;
    protected Jugador jugador;
    protected Partida partida;

    public FrmClienteAux(SocketCliente cliente, Jugador jugador, Partida partida) {
        this.cliente=cliente;
        this.cliente = cliente;
        this.partida=partida;
    }
    
}
