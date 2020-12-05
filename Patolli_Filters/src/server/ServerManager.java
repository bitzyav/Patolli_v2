/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dominio.EstadoPartida;
import dominio.Partida;
import filters.Filter;
import filters.FilterColores;
import filters.FilterConfiguracion;
import filters.FilterUnirJugador;
import filters.Pipe;
import filters.PipeFinal;
import filters.PipeImpl;
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
    private Proxy proxyConfiguracion;
    private Sink<Partida> sink;

    public ServerManager() {
        inicializar();
    }

    private void inicializar() {
        this.clientes = new ArrayList<>();
        this.sink = new SinkCliente(this);

        //Para la línea de producción de configuración
        Filter filterConfig = new FilterConfiguracion();
        Pipe<Partida> pipeConfig1 = new PipeImpl<>(filterConfig);
        Pipe<Partida> pipeConfigFinal = new PipeFinal<>(this.sink);

        filterConfig.setInput(pipeConfig1);
        filterConfig.setOutput(pipeConfigFinal);

        proxyConfiguracion = new Proxy(pipeConfig1);

        //Para la línea de producción de conexiones
        Filter filterUnirJugador = new FilterUnirJugador();
        Filter filterColores = new FilterColores();
        Pipe<Partida> pipeConexion1 = new PipeImpl<>(filterUnirJugador);

        Pipe<Partida> pipeConexion2 = new PipeImpl<>(filterColores);
        Pipe<Partida> pipeConexionFinal = new PipeFinal<>(this.sink);

        filterUnirJugador.setInput(pipeConexion1);
        filterUnirJugador.setOutput(pipeConexion2);

        filterColores.setInput(pipeConexion2);
        filterColores.setOutput(pipeConexionFinal);

        proxyConexiones = new Proxy(pipeConexion1);

        escuchar();
    }

    private void escuchar() {
        try {
            PatolliServer cliente1 = new PatolliServer(new ServerSocket(4444), this, this);
            System.out.println("Servidor iniciado");
            cliente1.run();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int getNumConectados() {
        return this.clientes.size();
    }

    @Override
    public void update(Partida partida) {
        enviarPartidaAClientes(partida);
    }

    @Override
    public void update(PatolliServer conexion) {
        accionesConexion(conexion);
    }

    public void accionesConexion(PatolliServer conexion) {
        System.out.println("Un jugador se ha conectado");
        this.clientes.add(conexion);
        if (this.sink.getPartida().getEstado() == EstadoPartida.VACIA || this.sink.getPartida().getEstado() == EstadoPartida.CONFIGURACION) {
            proxyConfiguracion.enviar(this.sink.getPartida());
            if (this.clientes.size() > 1) {
                for (int i = 1; i < clientes.size(); i++) {
                    try {
                        clientes.get(i).getCliente().close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    clientes.remove(i);
                }
            }
        } else if (this.sink.getPartida().getEstado() == EstadoPartida.ESPERA) {
            this.proxyConexiones.enviar(this.sink.getPartida());
        }
    }

    public void enviarPartidaAClientes(Partida partida) {
        for (PatolliServer cliente : clientes) {
            try {
                cliente.enviarPartida(partida);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void updatePartida(Partida partida) {
        System.out.println(partida);
        switch (partida.getEstado()) {
            case CONFIGURACION:
                this.proxyConfiguracion.enviar(partida);
                break;
            case ESPERA:
                this.proxyConexiones.enviar(partida);
                break;
            case INICIADA:
                this.proxyJuego.enviar(partida);
                break;
        }
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
