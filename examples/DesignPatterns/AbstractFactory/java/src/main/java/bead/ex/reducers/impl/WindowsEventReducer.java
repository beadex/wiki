package bead.ex.reducers.impl;

import bead.ex.models.dispatchers.Dispatcher;
import bead.ex.models.dispatchers.impl.WindowsEventDispatcher;
import bead.ex.models.listeners.EventType;
import bead.ex.models.listeners.Listener;
import bead.ex.models.listeners.impl.WindowsEventListener;
import bead.ex.reducers.Reducer;

import java.util.Random;

public class WindowsEventReducer implements Reducer {
    private final Random rand = new Random();
    @Override
    public Dispatcher createDispatcher() {
        return new WindowsEventDispatcher(rand.nextInt(255), rand.nextInt(128));
    }

    @Override
    public Listener createListener(EventType type) {
        return new WindowsEventListener(type);
    }
}
