package bead.ex.reducers.impl;

import bead.ex.models.dispatchers.Dispatcher;
import bead.ex.models.dispatchers.impl.ClosureEventDispatcher;
import bead.ex.models.listeners.EventType;
import bead.ex.models.listeners.Listener;
import bead.ex.models.listeners.impl.ClosureEventListener;
import bead.ex.reducers.Reducer;

import java.util.Random;

public class ClosureEventReducer implements Reducer {
    private final Random rand = new Random();

    @Override
    public Dispatcher createDispatcher() {
        return new ClosureEventDispatcher(rand.nextInt(255), rand.nextInt(512));
    }

    @Override
    public Listener createListener(EventType type) {
        return new ClosureEventListener(type);
    }
}
