package bead.ex.reducers;

import bead.ex.models.dispatchers.Dispatcher;
import bead.ex.models.listeners.EventType;
import bead.ex.models.listeners.Listener;

public interface Reducer {
    Dispatcher createDispatcher();
    Listener createListener(EventType type);
}
