package bead.ex.models.dispatchers;

public class ActionResult extends Action {
    private int dispatcherID;
    private int registeredID;

    private DispatcherType dispatcherType;

    public ActionResult(ActionType type, String payload, int dispatcherID, int registeredID, DispatcherType dispatcherType) {
        super(type, payload);
        this.dispatcherID = dispatcherID;
        this.registeredID = registeredID;
        this.dispatcherType = dispatcherType;
    }

    public int getDispatcherID() {
        return dispatcherID;
    }

    public void setDispatcherID(int dispatcherID) {
        this.dispatcherID = dispatcherID;
    }

    public int getThreadID() {
        return registeredID;
    }

    public void setThreadID(int threadID) {
        this.registeredID = threadID;
    }

    public DispatcherType getDispatcherType() {
        return dispatcherType;
    }

    public void setDispatcherType(DispatcherType dispatcherType) {
        this.dispatcherType = dispatcherType;
    }
}
