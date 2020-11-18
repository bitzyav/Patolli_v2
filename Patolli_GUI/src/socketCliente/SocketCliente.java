/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author alfonsofelix
 */
public class SocketCliente {

    private Socket cliente;
    private PrintWriter out;
    private BufferedReader in;

    public String conectar(String ip) throws IOException {

        cliente = new Socket(ip, 4444);
        out = new PrintWriter(cliente.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        if ((fromServer = in.readLine()) != null) {
            out.close();
            in.close();
            stdIn.close();
            cliente.close();
            return fromServer;
        }

        return null;
    }
}
