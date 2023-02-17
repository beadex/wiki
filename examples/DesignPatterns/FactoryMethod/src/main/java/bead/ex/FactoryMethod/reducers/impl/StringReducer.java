package bead.ex.FactoryMethod.reducers.impl;

import bead.ex.FactoryMethod.dispatchers.Dispatcher;
import bead.ex.FactoryMethod.dispatchers.impl.StringDispatcher;
import bead.ex.FactoryMethod.reducers.ReducerCreator;

import java.util.Random;

public class StringReducer extends ReducerCreator<String> {
    private final Random rand = new Random();
    @Override
    public Dispatcher<String> createDispatcher() {
        return new StringDispatcher(rand.nextInt(255));
    }
}
