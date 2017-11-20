package sync.impl;

import sync.interfaces.Generator;
import sync.interfaces.Observer;

import java.util.HashSet;
import java.util.Set;

/**
 * Concrete subject
 */
public class GeneratorImpl implements Generator {

    private int value = 0;
    private Set<GeneratorObserver> observers = new HashSet<>();

    /**
     * Constructor
     */
    public GeneratorImpl(){
    }

    /**
     * Generate a random value for this.value
     */
    @Override
    public void generateValue() {
        value = (int) (Math.random() * 1000);
        update();
    }

    /**
     * get the value
     * @return value
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * add an observer
     * @param observer
     */
    @Override
    public void attach(Observer observer) {
        observers.add((GeneratorObserver) observer);
    }

    /**
     * delete the observer
     * @param observer
     */
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * update all observers
     */
    private void update(){
        for(GeneratorObserver observer : observers){
            observer.update(this);
        }
    }
}
