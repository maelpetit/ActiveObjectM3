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

    public GeneratorImpl(){
    }

    @Override
    public void generateValue() {
        value = (int) (Math.random() * 1000);
        update();
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void attach(Observer observer) {
        observers.add((GeneratorObserver) observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    private void update(){
        for(GeneratorObserver observer : observers){
            observer.update(this);
        }
    }
}
