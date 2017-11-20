package sync.impl;

import sync.interfaces.Generator;
import sync.interfaces.Observer;

/**
 * Concrete observer
 */
public class GeneratorObserver implements Observer<Generator> {

    /**
     * update observer
     * @param subject
     */
    @Override
    public void update(Generator subject) {
        System.out.println(subject.getValue());
    }
}
