package dispatchers.impl;

import dispatchers.Dispatcher;
import models.Action;
import models.ActionResult;

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
