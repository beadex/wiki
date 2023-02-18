package bead.ex.models.dispatchers.impl;

import bead.ex.models.dispatchers.Action;
import bead.ex.models.dispatchers.ActionResult;
import bead.ex.models.dispatchers.Dispatcher;
import bead.ex.models.dispatchers.DispatcherType;

public class WindowsEventDispatcher implements Dispatcher {
    private int dispatcherID;
    private int signed;

    private static final DispatcherType type = DispatcherType.SIGNED;

    public WindowsEventDispatcher(int dispatcherID, int signed) {
        this.dispatcherID = dispatcherID;
        this.signed = signed;
    }

    @Override
    public ActionResult dispatch(Action action) {
        return null;
    }

    public int getDispatcherID() {
        return dispatcherID;
    }

    public void setDispatcherID(int dispatcherID) {
        this.dispatcherID = dispatcherID;
    }

    public int getSigned() {
        return signed;
    }

    public void setSigned(int signed) {
        this.signed = signed;
    }
}
