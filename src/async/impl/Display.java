package async.impl;

import async.interfaces.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Concrete observer
 */
public class Display implements Observer<AsyncGenerator> {

    private String name;

    public Display(String name){
        this.name = name;
    }

    @Override
    public void update(AsyncGenerator asyncGenerator) {
        try {
            System.out.println(name + " " + asyncGenerator.getValue().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
