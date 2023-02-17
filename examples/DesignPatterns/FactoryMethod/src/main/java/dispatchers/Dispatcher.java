package dispatchers;

import models.Action;
import models.ActionResult;

public interface Dispatcher<T> {
    ActionResult<T> dispatch(Action<T> action);
}
