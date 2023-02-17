package bead.ex.FactoryMethod.models;

import bead.ex.FactoryMethod.enums.ActionType;

public class ActionResult<T> extends Action<T> {
    private int dispatcherID;
    public ActionResult(ActionType type, T payload, int dispatcherID) {
        super(type, payload);
        this.dispatcherID = dispatcherID;
    }

    public int getDispatcherID() {
        return dispatcherID;
    }

    public void setDispatcherID(int dispatcherID) {
        this.dispatcherID = dispatcherID;
    }
}
