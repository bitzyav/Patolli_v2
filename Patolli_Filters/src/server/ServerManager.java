package server;

import dominio.EstadoPartida;
import dominio.Partida;
import filters.Filter;
import filters.FilterApuesta;
import filters.FilterConfiguracion;
import filters.FilterDado;
import filters.FilterMovimiento;
import filters.FilterRetiro;
import filters.FilterUnirJugador;
import filters.FilterVictoria;
import filters.Pipe;
import filters.PipeFinal;
import filters.PipeImpl;
import filters.Sink;
import filters.SinkCliente;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que ayuda a controlar el servidor.
 * Maneja el envío y recibimiento de los datos para saber qué hacer con ellos.
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

    /**
     * Método para inicializar las líneas de producción que se utilizarán
     * antes y durante el juego.
     */
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
        Pipe<Partida> pipeConexion1 = new PipeImpl<>(filterUnirJugador);
        Pipe<Partida> pipeConexionFinal = new PipeFinal<>(this.sink);

        filterUnirJugador.setInput(pipeConexion1);
        filterUnirJugador.setOutput(pipeConexionFinal);

        proxyConexiones = new Proxy(pipeConexion1);

        //Para la línea de producción del juego
        Filter filterDado = new FilterDado();
        Filter filterMovimiento = new FilterMovimiento();
        Filter filterApuesta = new FilterApuesta();
        Filter filterRetiro = new FilterRetiro();
        Filter filterVictoria = new FilterVictoria();

        Pipe<Partida> pipeJuego1 = new PipeImpl<>(filterRetiro);
        Pipe<Partida> pipeJuego2 = new PipeImpl<>(filterDado);
        Pipe<Partida> pipeJuego3 = new PipeImpl<>(filterMovimiento);
        Pipe<Partida> pipeJuego4 = new PipeImpl<>(filterApuesta);
        Pipe<Partida> pipeJuego5 = new PipeImpl<>(filterVictoria);
        Pipe<Partida> pipeJuegoFinal = new PipeFinal<>(this.sink);
        
        filterRetiro.setInput(pipeJuego1);
        filterRetiro.setOutput(pipeJuego2);
        
        filterDado.setInput(pipeJuego2);
        filterDado.setOutput(pipeJuego3);
        
        filterMovimiento.setInput(pipeJuego3);
        filterMovimiento.setOutput(pipeJuego4);
        
        filterApuesta.setInput(pipeJuego4);
        filterApuesta.setOutput(pipeJuego5);

        filterVictoria.setInput(pipeJuego5);
        filterVictoria.setOutput(pipeJuegoFinal);

        proxyJuego = new Proxy(pipeJuego1);

        escuchar();
    }

    /**
     * Método para comenzar a escuchar por el servidor y estar listo para
     * recibir al primer jugador.
     */
    private void escuchar() {
        try {
            PatolliServer cliente1 = new PatolliServer(new ServerSocket(4444), this, this);
            System.out.println("Servidor iniciado");
            cliente1.run();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método para obtener el número de jugadores conectados.
     * @return Número de jugadores conectados.
     */
    @Override
    public int getNumConectados() {
        return this.clientes.size();
    }

    /**
     * Método para saber cuando el observado tiene algo para enviar a los clientes.
     * @param partida Instancia de la partida a enviar.
     */
    @Override
    public void update(Partida partida) {
        enviarPartidaAClientes(partida);
    }

    /**
     * Método que se encarga de saber cuando el servidor notifica de una nueva
     * conexión
     * @param conexion Instancia de la conexión a agregar.
     */
    @Override
    public void update(PatolliServer conexion) {
        accionesConexion(conexion);
    }

    /**
     * Método para agregar la conexión a la lista de clientes y preparar para recibir
     * a más clientes.
     * @param conexion 
     */
    public void accionesConexion(PatolliServer conexion) {
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

    /**
     * Método que se encarga de enviar la partida a los clientes conectados.
     * @param partida Instancia de la partida a enviar.
     */
    public void enviarPartidaAClientes(Partida partida) {
        for (PatolliServer cliente : clientes) {
            try {
                cliente.enviarPartida(partida);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Método que se encarga de enviar a los filtros necesarios la partida
     * que acaba de llegar al servidor.
     * @param partida Instancia de la Partida a filtrar.
     */
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
}
