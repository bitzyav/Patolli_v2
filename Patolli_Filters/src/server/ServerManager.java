/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dominio.Partida;
import filters.Proxy;
import filters.Sink;
import filters.SinkCliente;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfonsofelix
 */
public class ServerManager implements ObserverManager, ObserverConexion {

    private List<PatolliServer> clientes;
    private Proxy proxyConexiones;
    private Proxy proxyJuego;
    private Sink<Partida> sink;

    public ServerManager() {
        inicializar();
    }

    private void inicializar() {
        this.clientes = new ArrayList<>();
            
        //Para la línea de producción de conexiones
        //proxyConexiones=new Proxy();
        escuchar();
    }

    private void escuchar() {
        try {
            PatolliServer cliente1 = new PatolliServer(new ServerSocket(4444), this, this);
            cliente1.run();
        } catch (IOException ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getNumConectados() {
        return this.clientes.size();
    }

    @Override
    public void update(Partida partida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(PatolliServer conexion) {

        this.clientes.add(conexion);
    }

    @Override
    public void updatePartida(Partida partida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private byte[] serializar(Partida partida) throws IOException {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        os.writeObject(partida);
        os.close();
        return bs.toByteArray();
    }

    private Partida deserializar(byte[] partidaSerializada) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bs = new ByteArrayInputStream(partidaSerializada); // bytes es el byte[]
        ObjectInputStream is = new ObjectInputStream(bs);
        Partida partida = (Partida) is.readObject();
        is.close();
        return partida;
    }

}
