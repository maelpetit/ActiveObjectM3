package async.interfaces;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Service
 */
public interface AsyncGenerator {
    Future<Integer> getValue();
}
