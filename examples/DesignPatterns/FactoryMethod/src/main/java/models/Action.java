package models;

import enums.ActionType;

public class Action<T> {
    private ActionType type;
    private T payload;

    public Action(ActionType type, T payload) {
        this.type = type;
        this.payload = payload;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
