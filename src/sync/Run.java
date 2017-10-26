package sync;

import sync.impl.GeneratorImpl;
import sync.impl.GeneratorObserver;
import sync.interfaces.Generator;

public class Run {
    public static void main(String[] args){
        Generator generator = new GeneratorImpl();
        GeneratorObserver observer = new GeneratorObserver();
        generator.attach(observer);

        while(true){
            generator.generateValue();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
