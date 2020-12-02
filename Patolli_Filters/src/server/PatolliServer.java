/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dominio.Jugador;
import dominio.Partida;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
    private Jugador jugador;
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
            PrintWriter out = null;
            BufferedReader in = null;
            out = new PrintWriter(cliente.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    cliente.getInputStream()));

            String inputLine, outputLine;
            if (serverManagerConexion.getNumConectados() < 4) {
                notificarConexion();
                outputLine = "Conectado a Patolli, eres el jugador #" + serverManagerConexion.getNumConectados();
                out.println(outputLine);
                while (true) {

                    /*while ((inputLine = in.readLine()) != null) {
                        outputLine = kkp.processInput(inputLine);
                        out.println(outputLine);
                        if (outputLine.equals("Bye.")) {
                            break;
                        }
                    }*/
                }
            }else{
                outputLine = "Lo sentimos :( el servidor está lleno." + serverManagerConexion.getNumConectados();
                out.println(outputLine);
                in.close();
                out.close();
                cliente.close();
            }

        } catch (IOException e) {
            System.err.println("Ocurrió un error en el puerto 4444.");
        }
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

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
