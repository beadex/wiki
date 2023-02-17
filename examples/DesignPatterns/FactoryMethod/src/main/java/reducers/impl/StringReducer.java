package reducers.impl;

import dispatchers.Dispatcher;
import dispatchers.impl.StringDispatcher;
import reducers.ReducerCreator;

import java.util.Random;

public class StringReducer extends ReducerCreator<String> {
    private final Random rand = new Random();
    @Override
    public Dispatcher<String> createDispatcher() {
        return new StringDispatcher(rand.nextInt(255));
    }
}
