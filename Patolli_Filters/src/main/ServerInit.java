package main;

import dominio.Partida;
import filters.SocketServer;
import java.io.IOException;
import java.net.ServerSocket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfonsofelix
 */
public class ServerInit{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
       ServerSocket socket = new ServerSocket(4444);
       new SocketServer(socket);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
