package async.impl;

import async.interfaces.*;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class GeneratorImpl implements Generator , Subject<AsyncObserver>{

    private int value = 0;// 2587;
    private Set<AsyncObserver> asyncObservers = new HashSet<>();
    private Strategy strategy;

    public GeneratorImpl(Strategy strategy){
        this.strategy = strategy;
        this.strategy.configure(this);
    }

    public void addAsyncObserver(AsyncObserver asyncObserver){
        this.asyncObservers.add(asyncObserver);
    }

    public void changeStrategy(Strategy strategy){
        this.strategy = strategy;
        this.strategy.configure(this);
    }

    public Set<AsyncObserver> getAsyncObservers() {
        return asyncObservers;
    }

    @Override
    public void generate() {
        value++;// = (int) ((Math.log(value) * 1e8) % 10000);
        strategy.execute();
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void attach(Observer<AsyncObserver> observer) {
    }

    @Override
    public void detach(Observer<AsyncObserver> observer) {

    }


}
