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
    protected static SocketCliente cliente;
    protected static Jugador jugador;
    protected static Partida partida;

    public FrmClienteAux(SocketCliente clienteN, Jugador jugadorN, Partida partidaN) {
        cliente=clienteN;
        cliente = clienteN;
        partida=partidaN;
    }
    
    public FrmClienteAux(){
        
    }
}
