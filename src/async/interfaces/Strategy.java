package async.interfaces;

import async.impl.GeneratorImpl;

public interface Strategy {

    void configure(GeneratorImpl generator);
    void execute();
}
