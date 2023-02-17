package bead.ex.FactoryMethod.reducers;

import bead.ex.FactoryMethod.models.Action;
import bead.ex.FactoryMethod.models.ActionResult;

public interface Reducer<T> {
  ActionResult<T> reduce(Action<T> action);
}
