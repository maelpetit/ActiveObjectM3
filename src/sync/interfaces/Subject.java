package sync.interfaces;

public interface Subject {
    /**
     * attach an observer
     * @param observer
     */
    void attach(Observer observer);

    /**
     * delete an observer
     * @param observer
     */
    void detach(Observer observer);
}
