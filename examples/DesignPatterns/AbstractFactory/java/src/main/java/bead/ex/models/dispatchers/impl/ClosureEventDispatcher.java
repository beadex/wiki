package bead.ex.models.dispatchers.impl;

import bead.ex.models.dispatchers.Action;
import bead.ex.models.dispatchers.ActionResult;
import bead.ex.models.dispatchers.Dispatcher;
import bead.ex.models.dispatchers.DispatcherType;

public class ClosureEventDispatcher implements Dispatcher {
    private int dispatcherID;
    private int registeredThreadID;

    private static final DispatcherType type = DispatcherType.THREAD;

    public ClosureEventDispatcher(int dispatcherID, int registeredThreadID) {
        this.dispatcherID = dispatcherID;
        this.registeredThreadID = registeredThreadID;
    }

    @Override
    public ActionResult dispatch(Action action) {
        return new ActionResult(action.getType(), action.getPayload(), this.dispatcherID, this.registeredThreadID, ClosureEventDispatcher.type);
    }

    public int getDispatcherID() {
        return dispatcherID;
    }

    public void setDispatcherID(int dispatcherID) {
        this.dispatcherID = dispatcherID;
    }

    public int getRegisteredThreadID() {
        return registeredThreadID;
    }

    public void setRegisteredThreadID(int registeredThreadID) {
        this.registeredThreadID = registeredThreadID;
    }
}
