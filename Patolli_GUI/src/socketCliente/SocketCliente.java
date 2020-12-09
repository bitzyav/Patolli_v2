/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketCliente;

import dominio.Partida;
import frames.Observer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfonsofelix
 */
public class SocketCliente implements Runnable {

    private Observer observer;
    private Socket cliente;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private String ip;

    public SocketCliente(String ip) {
        this.ip = ip;
    }

    public void conectar(String ip) throws IOException, ClassNotFoundException {
        if (cliente == null) {
            cliente = new Socket(ip, 4444);
            //  out = new PrintWriter(cliente.getOutputStream(), true);
            in = new ObjectInputStream(cliente.getInputStream());
            out = new ObjectOutputStream(cliente.getOutputStream());
            Partida partida = null;
            try {
                partida = (Partida) in.readObject();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            notificar(partida);
        }
        while (true) {
            try {
                Partida partida;
                if ((partida = (Partida) in.readObject()) != null) {
                    notificar(partida);
                    System.out.println("notificó");
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }

        }
    }

    private void notificar(Partida partida) {
        if (partida != null) {
            observer.update(partida);
        }
    }

    public void enviar(Partida partida) throws IOException {
        if (cliente.isConnected()) {
            out.writeObject(partida);
        }
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    /*   private byte[] serializar(Partida partida) throws IOException {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        os.writeObject(partida);
        os.close();
        return bs.toByteArray();
    }

    private Partida deserializar(Object partida) throws IOException, ClassNotFoundException {
        Partida p = (Partida) partida;
        return p;
    }*/
    @Override
    public void run() {
        try {
            conectar(ip);
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
