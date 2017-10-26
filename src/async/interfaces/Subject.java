package async.interfaces;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
}
