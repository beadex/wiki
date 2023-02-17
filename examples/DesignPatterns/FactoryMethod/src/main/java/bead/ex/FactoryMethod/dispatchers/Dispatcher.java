package bead.ex.FactoryMethod.dispatchers;

import bead.ex.FactoryMethod.models.Action;
import bead.ex.FactoryMethod.models.ActionResult;

public interface Dispatcher<T> {
    ActionResult<T> dispatch(Action<T> action);
}
