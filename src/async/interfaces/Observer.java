package async.interfaces;

public interface Observer<T> {
    void update(T subject);
}
