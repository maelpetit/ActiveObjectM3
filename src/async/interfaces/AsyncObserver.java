package async.interfaces;

import java.util.concurrent.Future;

public interface AsyncObserver<T> {
    Future<Void> update(T subject);
}
