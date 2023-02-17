package dispatchers.impl;

import dispatchers.Dispatcher;
import models.Action;
import models.ActionResult;

public class IntergerDispatcher implements Dispatcher<Integer> {
    private int dispatcherID;

    public IntergerDispatcher(int dispatcherID) {
        this.dispatcherID = dispatcherID;
    }

    @Override
    public ActionResult<Integer> dispatch(Action<Integer> action) {
        return new ActionResult<>(action.getType(), action.getPayload(), this.dispatcherID);
    }

    public int getDispatcherID() {
        return dispatcherID;
    }

    public void setDispatcherID(int dispatcherID) {
        this.dispatcherID = dispatcherID;
    }
}
