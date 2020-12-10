package filters;

/**
 * Clase encargada de filtrar el estado de un objeto y hacer ajustes.
 *
 * @author alfonsofelix
 */
public abstract class Filter<I, O> {

    protected Pipe<I> input;
    protected Pipe<O> output;

    public Filter() {
    }

    /**
     * Asigna el Pipe por el cual se recibirá el estado de un objeto a filtrar.
     *
     * @param input Instancia del Pipe por donde se recibirá.
     */
    public void setInput(Pipe<I> input) {
        this.input = input;
    }

    /**
     * Asigna el Pipe por el cual se enviará el objeto filtrado./
     *
     * @param output Instancia del Pipe por donde saldrá el objeto.
     */
    public void setOutput(Pipe<O> output) {
        this.output = output;
    }

    /**
     * Método encargado de hacer los ajustes al objeto. (Filtrar el objeto).
     */
    protected abstract void doFilter();
}
