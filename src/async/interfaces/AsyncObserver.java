package async.interfaces;

import java.util.concurrent.Future;

/**
 * AsyncObserver interface
 * @param <T>
 */
public interface AsyncObserver<T> {
    Future<Void> update(T subject);
}
