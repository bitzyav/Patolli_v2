package server;

import dominio.Partida;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase auxiliar para realizar los envíos y recibimientos de la Partida entre
 * cliente y servidor. Lado cliente.
 *
 * @author alfonsofelix
 */
public class PatolliServer implements Runnable {

    private final ServerSocket serverSocket;
    private final ObserverConexion serverManagerConexion;
    private final ObserverManager serverManagerPartida;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket cliente;

    /**
     * Constructor que instancia un objeto e inicializa los siguientes valores.
     *
     * @param serverSocket El socket que se usa para escuchar clientes.
     * @param serverManagerConexion Instancia del observador para notificar
     * conexiones.
     * @param serverManagerPartida Instancia del observador para notificar
     * llegada de objetos.
     */
    public PatolliServer(ServerSocket serverSocket, ObserverConexion serverManagerConexion, ObserverManager serverManagerPartida) {
        this.serverSocket = serverSocket;
        this.serverManagerConexion = serverManagerConexion;
        this.serverManagerPartida = serverManagerPartida;
    }

    /**
     * Método que comienza a ejecutar lo necesario al iniciar el hilo.
     */
    @Override
    public void run() {
        escuchar();
    }

    /**
     * Método que se encarga de aceptar la conexión del cliente.
     * También se encarga de escuchar la llegada de datos.
     *
     */
    private void escuchar() {
        try {
            cliente = null;
            cliente = serverSocket.accept();
            PatolliServer hilo = new PatolliServer(serverSocket, serverManagerConexion, serverManagerPartida);
            new Thread(hilo).start();

            out = new ObjectOutputStream(cliente.getOutputStream());
            in = new ObjectInputStream(cliente.getInputStream());

            notificarConexion();

            while (true) {
                try {
                    Partida partida;
                    if ((partida = (Partida) in.readObject()) != null) {
                        notificarMovimiento(partida);
                    }
                } catch (Exception e) {
                    if (e.getMessage().contains("Connection reset") || e.getMessage().contains("socket closed")) {
                        if (out != null && in != null && cliente != null) {
                            out.close();
                            in.close();
                            cliente.close();
                        }
                        break;
                    }
                    System.out.println("Error al avanzar ficha: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
        }
    }

    /**
     * Método para enviar la partida a su respectivo cliente.
     * @param partida Instancia de la Partida a enviar.
     */
    public void enviarPartida(Partida partida) throws IOException {
        this.out.writeObject(partida);
    }

    /**
     * Método para obtener la instancia del Socket.
     * @return Instancia del socket del cliente.
     */
    public Socket getCliente() {
        return cliente;
    }

    /**
     * Método para notificar al observador que alguien se ha conectado al servidor.
     */
    private void notificarConexion() {
        serverManagerConexion.update(this);
    }

    /**
     * Método para notificar al observador que llegó un objeto al servidor.
     * @param partida 
     */
    private void notificarMovimiento(Partida partida) {
        serverManagerConexion.updatePartida(partida);
    }

    /*private byte[] serializar(Partida partida, ObjectOutputStream os) throws IOException {
        os.writeObject(partida);
        
        return ;
    }*/
}
