/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketCliente;

import dominio.Partida;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfonsofelix
 */
public class SocketCliente {

    private Socket cliente;
    private PrintWriter out;
    private ObjectInputStream in;

    public Partida conectar(String ip) throws IOException, ClassNotFoundException {

        cliente = new Socket(ip, 4444);
        out = new PrintWriter(cliente.getOutputStream(), true);
        in = new ObjectInputStream(cliente.getInputStream());
        
        out.close();
        in.close();
        cliente.close();

        Partida partida = deserializar(in.readObject());

        return partida;
    }

    private byte[] serializar(Partida partida) throws IOException {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        os.writeObject(partida);
        os.close();
        return bs.toByteArray();
    }

    private Partida deserializar(Object partida) throws IOException, ClassNotFoundException {
        Partida p = (Partida) partida;
        return p;
    }
}
