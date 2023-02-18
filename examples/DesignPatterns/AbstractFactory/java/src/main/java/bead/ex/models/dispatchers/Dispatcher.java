package bead.ex.models.dispatchers;

public interface Dispatcher {
    ActionResult dispatch(Action action);
}
