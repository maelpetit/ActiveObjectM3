package async.impl;

import async.interfaces.*;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * proxy
 */
public class Channel implements AsyncGenerator, AsyncGeneratorObserver {

    private Set<Observer> observers = new HashSet<>();
    private ScheduledExecutorService scheduledExecutorService;
    private Generator generator;

    public Channel(Generator generator, ScheduledExecutorService scheduledExecutorService){
        this.scheduledExecutorService = scheduledExecutorService;
        this.generator = generator;
    }

    @Override
    public Future<Void> update(Generator subject) {
        return (Future<Void>) scheduledExecutorService.schedule(()-> updateForEach(), 1000, TimeUnit.MILLISECONDS);
    }

    @Override
    public Future<Integer> getValue() {
        return scheduledExecutorService.schedule(new GetValue(generator), 1000, TimeUnit.MILLISECONDS);
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    private void updateForEach(){
        for (Observer observer: observers) {
            observer.update(this);
        }
    }

}
