package async.interfaces;

import async.impl.GeneratorImpl;

import java.util.Set;

public interface Strategy {

    void configure(GeneratorImpl generator);
    void execute();
}
