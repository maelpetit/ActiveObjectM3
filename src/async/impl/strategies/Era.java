package async.impl.strategies;

import async.impl.GeneratorImpl;
import async.interfaces.Strategy;

public class Era implements Strategy{

    private GeneratorImpl generator;

    /**
     * configure generator
     * @param generator
     */
    @Override
    public void configure(GeneratorImpl generator) {
        this.generator = generator;
    }

    /**
     * execute generator
     */
    @Override
    public void execute() {
        //TODO implements the Era strategy
    }
}
