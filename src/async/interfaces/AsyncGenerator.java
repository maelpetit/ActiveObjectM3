package async.interfaces;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * AsyncGenerator interface
 * Servant
 */
public interface AsyncGenerator {
    Future<Integer> getValue();
}
