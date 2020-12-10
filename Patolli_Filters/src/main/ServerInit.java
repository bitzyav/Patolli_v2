package main;

import server.ServerManager;

/**
 * Clase que se encarga de encender el servidor
 * @author alfonsofelix
 */
public class ServerInit{

    /**
     * Método que se encarga de arrancar el servidor.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ServerManager();
    }
    
}
