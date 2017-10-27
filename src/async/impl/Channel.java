package async.impl;

import async.interfaces.*;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * proxy
 */
public class Channel implements AsyncGenerator, AsyncObserver<Generator>, Subject<AsyncGenerator> {

    private Observer<AsyncGenerator> observer;
    private ScheduledExecutorService scheduledExecutorService;
    private Generator generator;
    private int delay;

    public Channel(Generator generator, ScheduledExecutorService scheduledExecutorService, int delay){
        this.scheduledExecutorService = scheduledExecutorService;
        this.generator = generator;
        this.delay = delay;
    }

    @Override
    public Future<Void> update(Generator subject) {
        return scheduledExecutorService.schedule(() -> {
            if(observer != null) {
                observer.update(this);
            }
            return null;
        }, 100, TimeUnit.MILLISECONDS);
    }

    @Override
    public Future<Integer> getValue() {
        return scheduledExecutorService.schedule(new GetValue(generator), delay, TimeUnit.MILLISECONDS);
    }

    @Override
    public void attach(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void detach(Observer observer) {
        if(observer == this.observer) {
            this.observer = null;
        }
    }


}
