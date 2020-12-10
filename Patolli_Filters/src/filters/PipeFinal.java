package filters;

/**
 * Clase encargada de hacer envíos entre el filtro final y el Sink
 *
 * @author alfonsofelix
 */
public class PipeFinal<T> implements Pipe<T> {

    private T objeto;
    private Sink<T> sink;

    /**
     * Construye la instancia e inicializa los siguientes valores:
     *
     * @param filter Instancia del sink al que se enviará el objeto.
     */
    public PipeFinal(Sink<T> sink) {
        this.sink = sink;
    }

    /**
     * Método para asignar el objeto que se enviará al sink.
     *
     * @param objeto Instancia del objeto a enviar.
     */
    @Override
    public void put(T objeto) {
        this.objeto = objeto;
    }

    /**
     * Método para obtener el objeto que proviene del último filtro.
     *
     * @return Instancia del objeto.
     */
    @Override
    public T get() {
        return null;
    }

    /**
     * Método que actualiza el estado del objeto en el Sink.
     */
    @Override
    public void doChain() {
        this.sink.actualizar(objeto);
    }
}
