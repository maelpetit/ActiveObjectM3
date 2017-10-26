package sync.interfaces;

public interface Observer<T> {
    void update(T subject);
}
