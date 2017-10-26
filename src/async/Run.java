package async;

import async.impl.Channel;
import async.impl.Display;
import async.impl.GeneratorImpl;
import async.interfaces.Generator;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run {

    public static void main(String[] args){
        Generator generator = new GeneratorImpl();
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(15);
        Channel channel = new Channel(generator, service);
        Display display = new Display(channel);
        service.scheduleAtFixedRate(()-> generator.generate(), 1000, 1000, TimeUnit.MILLISECONDS);

        /*for(int j = 0; j < 10000; j++) {
            int value = j;
            int startingValue = value;
            for (int i = 0; i < 1e6; i++) {
                //System.out.println((Math.log(value)));
                value = (int) ((Math.log(value) * 1e8) % 10000);
                //System.out.println(value);
                if (value == startingValue) {
                    System.out.println("Loop after " + (i + 1) + " iterations for " + startingValue);
                    break;
                }
            }
        }*/
    }
}
