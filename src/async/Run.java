package async;

import async.impl.strategies.Atomic;
import async.impl.Channel;
import async.impl.Display;
import async.impl.GeneratorImpl;
import async.interfaces.Generator;
import async.interfaces.Strategy;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run {

    public static void main(String[] args){
        Strategy atomicDistribution = new Atomic();
        Generator generator = new GeneratorImpl(atomicDistribution);
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(15);
        Channel channel1 = new Channel(generator, service, 100);
        Channel channel2 = new Channel(generator, service, 1000);
        Display display1 = new Display("1");
        Display display2 = new Display("2");
        channel1.attach(display1);
        channel2.attach(display2);
        ((GeneratorImpl) generator).addAsyncObserver(channel1);
        ((GeneratorImpl) generator).addAsyncObserver(channel2);

        service.scheduleAtFixedRate(()-> generator.generate(), 0, 100, TimeUnit.MILLISECONDS);
    }
}
