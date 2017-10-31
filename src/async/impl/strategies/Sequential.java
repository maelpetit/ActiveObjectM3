package async.impl.strategies;

import async.impl.GeneratorImpl;
import async.interfaces.Strategy;

public class Sequential implements Strategy{

    private GeneratorImpl generator;

    @Override
    public void configure(GeneratorImpl generator) {
        this.generator = generator;
    }

    @Override
    public void execute() {

    }
}
