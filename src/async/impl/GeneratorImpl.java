package async.impl;

import async.interfaces.*;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * GeneratorImpl
 */
public class GeneratorImpl implements Generator , Subject<AsyncObserver>{

    private int value = 0;// 2587;
    private Set<AsyncObserver> asyncObservers = new HashSet<>();
    private Strategy strategy;

    /**
     * Constructor
     * @param strategy
     */
    public GeneratorImpl(Strategy strategy){
        this.strategy = strategy;
        this.strategy.configure(this);
    }

    /**
     * Add an asyncObserver
     * @param asyncObserver
     */
    public void addAsyncObserver(AsyncObserver asyncObserver){
        this.asyncObservers.add(asyncObserver);
    }

    /**
     * Change the strategy
     * @param strategy
     */
    public void changeStrategy(Strategy strategy){
        this.strategy = strategy;
        this.strategy.configure(this);
    }

    /**
     * get all asyncObservers
     * @return Set<AsyncObserver>
     */
    public Set<AsyncObserver> getAsyncObservers() {
        return asyncObservers;
    }


    /**
     *  Generate strategy
     */
    @Override
    public void generate() {
        value++;// = (int) ((Math.log(value) * 1e8) % 10000);
        strategy.execute();
    }

    /**
     * get value
     * @return Integer value
     */
    @Override
    public Integer getValue() {
        return value;
    }

    /**
     * attach an asyncObserver
     * @param observer
     */
    @Override
    public void attach(Observer<AsyncObserver> observer) {
    }

    /**
     * delete an asyncObserver
     * @param observer
     */
    @Override
    public void detach(Observer<AsyncObserver> observer) {

    }

    public void reset(){
        value = 0;
    }

}
