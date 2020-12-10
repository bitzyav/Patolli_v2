package filters;

/**
 * Clase encargada de hacer envíos entre filtros.
 * @author alfonsofelix
 */
public class PipeImpl<T> implements Pipe<T> {

    private T objeto;
    private Filter filter;

    /**
     * Construye la instancia e inicializa los siguientes valores:
     * @param filter Instancia del filtro al que se enviará el objeto.
     */
    public PipeImpl(Filter filter) {
        this.filter = filter;
    }

    /**
     * Método para asignar el objeto que se enviará al siguiente filtro.
     * @param objeto Instancia del objeto a enviar.
     */
    @Override
    public void put(T objeto) {
        this.objeto = objeto;
    }

    /**
     * Método para obtener el objeto que proviene de otro filtro.
     * @return Instancia del objeto.
     */
    @Override
    public T get() {
        return this.objeto;
    }

    /**
     * Método que arranca las acciones del siguiente filtro.
     */
    @Override
    public void doChain() {
        filter.doFilter();
    }
}
