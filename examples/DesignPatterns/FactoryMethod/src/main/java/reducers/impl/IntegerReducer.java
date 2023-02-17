package reducers.impl;

import dispatchers.Dispatcher;
import dispatchers.impl.IntergerDispatcher;
import reducers.ReducerCreator;

import java.util.Random;

public class IntegerReducer extends ReducerCreator<Integer> {
    private final Random rand = new Random();
    @Override
    public Dispatcher<Integer> createDispatcher() {
        return new IntergerDispatcher(rand.nextInt(255));
    }
}
