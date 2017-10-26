package async.impl;

import async.interfaces.Generator;

import java.util.concurrent.Callable;

/**
 * Concrete method invocation
 */
public class GetValue implements Callable<Integer>{

    private Generator generator;

    public GetValue(Generator generator){
        this.generator = generator;
    }

    @Override
    public Integer call() throws Exception {
        int i = generator.getValue();
        //System.out.println("GetValue.call " + i);
        return i;
    }

}
