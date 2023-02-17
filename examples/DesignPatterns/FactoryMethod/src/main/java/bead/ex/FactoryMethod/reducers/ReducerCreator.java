package bead.ex.FactoryMethod.reducers;

import bead.ex.FactoryMethod.dispatchers.Dispatcher;
import bead.ex.FactoryMethod.models.Action;
import bead.ex.FactoryMethod.models.ActionResult;

public abstract class ReducerCreator<T> implements Reducer<T> {
    public abstract Dispatcher<T> createDispatcher();

    @Override
    public ActionResult<T> reduce(Action<T> action) {
        Dispatcher<T> dispatcher = createDispatcher();
        return dispatcher.dispatch(action);
    }
}
