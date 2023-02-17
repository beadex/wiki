package bead.ex.FactoryMethod.reducers.impl;

import bead.ex.FactoryMethod.dispatchers.Dispatcher;
import bead.ex.FactoryMethod.dispatchers.impl.IntergerDispatcher;
import bead.ex.FactoryMethod.reducers.Reducer;

import java.util.Random;

public class IntegerReducer extends Reducer<Integer> {
    private final Random rand = new Random();
    @Override
    public Dispatcher<Integer> createDispatcher() {
        return new IntergerDispatcher(rand.nextInt(255));
    }
}
