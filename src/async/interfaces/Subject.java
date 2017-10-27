package async.interfaces;

public interface Subject<T> {
    void attach(Observer<T> observer);
    void detach(Observer<T> observer);
}
