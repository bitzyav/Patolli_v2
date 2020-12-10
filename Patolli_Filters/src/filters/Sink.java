package filters;

import server.ObserverManager;

/**
 * Clase que mantiene el estado de la partida.
 *
 * @author alfonsofelix
 */
public abstract class Sink<T> {

    protected ObserverManager serverManager;
    protected T partida;

    /**
     * Construye la instancia de la clase e inicializa los siguientes valores:
     *
     * @param serverManager Instancia del observador.
     */
    public Sink(ObserverManager serverManager) {
        this.serverManager = serverManager;
    }

    /**
     * Método para obtener el estado del objeto.
     * @return Instancia con el estado del objeto.
     */
    public T getPartida() {
        return partida;
    }

    /**
     * Método que actualiza el estado del objeto
     * @param partida Instancia del nuevo estado del objeto.
     */
    public void actualizar(T partida) {
        this.partida = partida;
        notificar();
    }

    /**
     * Notifica al observador de que algo ha terminado de filtrarse.
     */
    protected abstract void notificar();
}
