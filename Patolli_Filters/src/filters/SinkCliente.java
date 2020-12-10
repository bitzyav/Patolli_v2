package filters;

import dominio.Partida;
import server.ObserverManager;

/**
 * Clase que mantiene el estado de la partida.
 * @author alfonsofelix
 */
public class SinkCliente extends Sink<Partida>{

    /**
     * Construye la instancia de la clase e inicializa los siguientes valores:
     * @param serverManager Instancia del observador.
     */
    public SinkCliente(ObserverManager serverManager) {
        super(serverManager);
        this.partida=new Partida();
    }
    
    /**
     * Notifica al observador de que algo ha terminado de filtrarse.
     */
    @Override
    protected void notificar() {
        serverManager.update(partida);
    }
    
}
