package async.interfaces;

import async.impl.GeneratorImpl;

/**
 * Strategy interface
 */
public interface Strategy {

    void configure(GeneratorImpl generator);
    void execute();
}
