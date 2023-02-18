package bead.ex.models.dispatchers;

public class Action {
    private ActionType type;
    private String payload;

    public Action(ActionType type, String payload) {
        this.type = type;
        this.payload = payload;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
