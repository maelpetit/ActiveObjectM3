package async.interfaces;

/**
 * Observable interface
 * @param <T>
 */
public interface Observer<T> {
    void update(T subject);
}
