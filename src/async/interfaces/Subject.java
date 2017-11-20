package async.interfaces;

/**
 * Subject interface
 * @param <T>
 */
public interface Subject<T> {
    void attach(Observer<T> observer);
    void detach(Observer<T> observer);
}
