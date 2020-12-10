package filters;

/**
 *
 * @author alfonsofelix
 */
public interface Pipe<T>{
    public void put(T objeto);
    public T get();
    public void doChain();
}
