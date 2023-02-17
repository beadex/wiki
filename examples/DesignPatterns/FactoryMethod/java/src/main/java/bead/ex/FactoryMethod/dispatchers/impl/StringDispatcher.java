package bead.ex.FactoryMethod.dispatchers.impl;

import bead.ex.FactoryMethod.dispatchers.Dispatcher;
import bead.ex.FactoryMethod.models.Action;
import bead.ex.FactoryMethod.models.ActionResult;

public class StringDispatcher implements Dispatcher<String> {
    private int dispatcherID;

    public StringDispatcher(int dispatcherID) {
        this.dispatcherID = dispatcherID;
    }

    @Override
    public ActionResult<String> dispatch(Action<String> action) {
        return new ActionResult<>(action.getType(), action.getPayload(), this.dispatcherID);
    }

    public int getDispatcherID() {
        return dispatcherID;
    }

    public void setDispatcherID(int dispatcherID) {
        this.dispatcherID = dispatcherID;
    }
}
