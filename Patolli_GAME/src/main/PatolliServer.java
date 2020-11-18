/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dominio.Jugador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author alfonsofelix
 */
public class PatolliServer implements Runnable {

    private ServerSocket serverSocket;
    private Socket[] clientes;
    private byte conectados;

    public PatolliServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        clientes = new Socket[4];
    }

    @Override
    public void run() {
        escuchar();
    }

    private void escuchar() {
        while (true) {
            try {
                Socket clientSocket = null;
                clientSocket = serverSocket.accept();
                PrintWriter out = null;
                BufferedReader in = null;

                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(
                        clientSocket.getInputStream()));
                if (conectados < 4) {
                    clientes[conectados] = clientSocket;
                    if (conectados == 0) {
                        out.println("Eres el host de la partida!");
                    } else {
                        out.println("Te has conectado al Patolli Server, eres el jugador " + (conectados + 1) + "!");
                    }
                    out.close();
                    in.close();
                    conectados++;
                } else {
                    out.println("Lo sentimos, la partida está llena :(");
                    out.close();
                    in.close();
                    clientSocket.close();
                }
            } catch (IOException e) {
                System.err.println("Ocurrió un error.");
                System.exit(1);
            }
        }
    }

}
