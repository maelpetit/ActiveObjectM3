package async.impl;

import async.interfaces.Generator;
import async.interfaces.GeneratorObserver;
import async.interfaces.Observer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Concrete observer
 */
public class Display implements GeneratorObserver {

    private Channel channel;
    private Future<Integer> future;

    public Display(Channel channel){
        this.channel = channel;
        this.channel.attach(this);
    }



    @Override
    public void update(Generator subject) {
        future = channel.getValue();

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
