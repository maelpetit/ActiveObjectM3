package async.impl;

import async.interfaces.AsyncObserver;
import async.interfaces.Generator;
import async.interfaces.Observer;
import async.interfaces.Subject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class GeneratorImpl implements Generator , Subject<AsyncObserver>{

    private int value = 2587;
    private Set<AsyncObserver> asyncObservers = new HashSet<>();

    public void addAsyncObserver(AsyncObserver asyncObserver){
        this.asyncObservers.add(asyncObserver);
    }

    @Override
    public void generate() {
        value = (int) ((Math.log(value) * 1e8) % 10000);
        updateAll();
    }

    @Override
    public Integer getValue() {
        return value;
    }

    private void updateAll(){
        for(AsyncObserver asyncObserver : asyncObservers){
            try {
                asyncObserver.update(this).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void attach(Observer<AsyncObserver> observer) {

    }

    @Override
    public void detach(Observer<AsyncObserver> observer) {

    }
}
