package async.impl.strategies;

import async.impl.GeneratorImpl;
import async.interfaces.AsyncObserver;
import async.interfaces.Strategy;


import java.util.concurrent.ExecutionException;

public class Atomic implements Strategy{

    private GeneratorImpl generator;

    @Override
    public void configure(GeneratorImpl generator) {
        this.generator = generator;
    }

    @Override
    public void execute() {
        for(AsyncObserver asyncObserver : generator.getAsyncObservers()){
            try {
                asyncObserver.update(generator).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
