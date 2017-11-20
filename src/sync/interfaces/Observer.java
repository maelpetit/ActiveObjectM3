package sync.interfaces;

/**
 * Observer interface
 * @param <T>
 */
public interface Observer<T> {
    void update(T subject);
}
