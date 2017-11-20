package async;

import async.impl.strategies.Atomic;
import async.impl.Channel;
import async.impl.Display;
import async.impl.GeneratorImpl;
import async.impl.strategies.Sequential;
import async.interfaces.Generator;
import async.interfaces.Strategy;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run {

    public static void main(String[] args){
        //Strategy atomicDistribution = new Atomic();
        Strategy seqDistribution = new Sequential();
        Generator generator = new GeneratorImpl(seqDistribution);
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(15);
        Channel channel1 = new Channel(generator, service, 100);
        Channel channel2 = new Channel(generator, service, 200);
        Channel channel3 = new Channel(generator, service, 300);
        Channel channel4 = new Channel(generator, service, 400);
        Display display1 = new Display("1");
        Display display2 = new Display("2");
        Display display3 = new Display("3");
        Display display4 = new Display("4");
        channel1.attach(display1);
        channel2.attach(display2);
        channel3.attach(display3);
        channel4.attach(display4);
        ((GeneratorImpl) generator).addAsyncObserver(channel1);
        ((GeneratorImpl) generator).addAsyncObserver(channel2);
        ((GeneratorImpl) generator).addAsyncObserver(channel3);
        ((GeneratorImpl) generator).addAsyncObserver(channel4);

        service.scheduleAtFixedRate(()-> generator.generate(), 0, 1000, TimeUnit.MILLISECONDS);
    }
}
