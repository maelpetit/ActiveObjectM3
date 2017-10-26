package async.impl;

import async.interfaces.Generator;

public class GeneratorImpl implements Generator {

    private int value = 2587;
    private Channel channel;

    @Override
    public void generate() {
        value = (int) ((Math.log(value) * 1e8) % 10000);
        channel.update(this);
    }

    @Override
    public Integer getValue() {
        return value;
    }


}
