package async.impl.strategies;

import async.impl.GeneratorImpl;
import async.interfaces.Strategy;

public class Era implements Strategy{

    private GeneratorImpl generator;

    @Override
    public void configure(GeneratorImpl generator) {
        this.generator = generator;
    }

    @Override
    public void execute() {

    }
}
