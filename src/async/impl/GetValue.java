package async.impl;

import async.interfaces.Generator;

import java.util.concurrent.Callable;

/**
 * Concrete method invocation
 */
public class GetValue implements Callable<Integer>{

    private Generator generator;

    /**
     * get Value
     * @param generator
     */
    public GetValue(Generator generator){
        this.generator = generator;
    }

    /**
     * call getValue
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        return generator.getValue();
    }

}
