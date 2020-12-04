/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dominio.Jugador;
import dominio.Partida;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Invitado
 */
public class PatolliServer implements Runnable {

    private ServerSocket serverSocket;
    private ObserverConexion serverManagerConexion;
    private ObserverManager serverManagerPartida;
    ObjectOutputStream out;
    ObjectInputStream in;
    private Socket cliente;

    public PatolliServer(ServerSocket serverSocket, ObserverConexion serverManagerConexion, ObserverManager serverManagerPartida) {
        this.serverSocket = serverSocket;
        this.serverManagerConexion = serverManagerConexion;
        this.serverManagerPartida = serverManagerPartida;
    }

    @Override
    public void run() {
        escuchar();
    }

    private void escuchar() {
        try {
            cliente = null;
            cliente = serverSocket.accept();
            PatolliServer hilo = new PatolliServer(serverSocket, serverManagerConexion, serverManagerPartida);
            new Thread(hilo).start();

            out = new ObjectOutputStream(cliente.getOutputStream());

            notificarConexion();

        } catch (IOException e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
        }
    }

    public void enviarPartida(Partida partida) throws IOException {
        this.out.writeObject(partida);
    }

    public Socket getCliente() {
        return cliente;
    }

    private void notificarConexion() {
        serverManagerConexion.update(this);
    }

    private void notificarMovimiento(Partida partida) {
        serverManagerConexion.updatePartida(partida);
    }

    /*private byte[] serializar(Partida partida, ObjectOutputStream os) throws IOException {
        os.writeObject(partida);
        
        return ;
    }*/
}
