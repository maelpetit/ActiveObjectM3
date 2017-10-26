package async.impl;

import async.interfaces.AsyncObserver;
import async.interfaces.Generator;
import async.interfaces.Observer;
import async.interfaces.Subject;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class Update implements Callable {

    private AsyncObserver observer;
    private Subject subject;

    public Update(AsyncObserver observer, Subject subject){
        this.observer = observer;
        this.subject = subject;
    }
    @Override
    public Future call() throws Exception {
        return observer.update(subject);
    }
}
