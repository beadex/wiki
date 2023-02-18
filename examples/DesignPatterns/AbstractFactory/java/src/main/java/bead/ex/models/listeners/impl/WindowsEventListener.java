package bead.ex.models.listeners.impl;

import bead.ex.models.listeners.Event;
import bead.ex.models.listeners.EventType;
import bead.ex.models.listeners.Listener;

public class WindowsEventListener implements Listener {
    private EventType type;

    public WindowsEventListener(EventType type) {
        this.type = type;
    }

    @Override
    public Event listen(String identifier) {
        return new Event(identifier, this.type);
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
