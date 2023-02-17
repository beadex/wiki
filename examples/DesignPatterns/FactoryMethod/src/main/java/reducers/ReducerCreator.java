package reducers;

import dispatchers.Dispatcher;
import models.Action;
import models.ActionResult;

public abstract class ReducerCreator<T> {
    public abstract Dispatcher<T> createDispatcher();

    public ActionResult<T> reduce(Action<T> action) {
        Dispatcher<T> dispatcher = createDispatcher();
        return dispatcher.dispatch(action);
    }
}
