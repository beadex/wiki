package bead.ex.models.listeners;

import java.util.Random;

public class Event {
    private String identifier;
    private EventType type;

    private final int value = new Random().nextInt(1024);

    public Event(String identifier, EventType type) {
        this.identifier = identifier;
        this.type = type;
    }

    public int spread() {
        switch (this.type) {
            case ADD:
                return value + 1;
            case CHANGE:
                return value * value;
            case DELETE:
                return 0;
            case VALUE:
            default:
                return value;
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public EventType getType() {
        return this.type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
