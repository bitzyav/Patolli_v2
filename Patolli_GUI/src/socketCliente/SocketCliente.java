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
import java.net.ConnectException;
import java.net.Socket;

/**
 * Clase auxiliar para realizar los envíos y recibimientos de la Partida entre cliente y servidor. Lado cliente.
 * @author alfonsofelix
 */
public class SocketCliente implements Runnable {

    private Observer observer;
    private Socket cliente;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private String ip;

    /**
     * Constructor que instancia un objeto e inicializa los siguientes valores:
     * @param ip La dirección IP del servidor.
     */
    public SocketCliente(String ip) {
        this.ip = ip;
    }

    /**
     * Método que se encarga de realizar la conexión con el servidor y 
     * escuchar la llegada de los datos.
     * @param ip La dirección IP del servidor.
     */
    public void conectar(String ip) throws IOException, ClassNotFoundException, ConnectException {
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
                }
            } catch (Exception e) {

            }
        }
    }

    /**
     * Método que notifica a sus observadores para indicar que algo llegó.
     * @param partida Instancia de la Partida que llegó.
     */
    private void notificar(Partida partida) {
        if (partida != null) {
            observer.update(partida);
        }
    }

    /**
     * Método que envía un objeto hacia el servidor.
     * @param partida Instancia de la partida a enviar.
     */
    public void enviar(Partida partida) throws IOException {
        if (cliente.isConnected()) {
            out.writeObject(partida);
        }
    }

    /**
     * Método que cambia al observador de esta clase.
     * @param observer Quien se desea que sea el observador.
     */
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
    
    /**
     * Método que comienza a ejecutar lo necesario al iniciar el hilo.
     */
    @Override
    public void run() {
        try {
            conectar(ip);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
