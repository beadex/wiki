import { Dispatcher } from '../dispatchers';
import { Action, ActionResult } from '../models';

export abstract class Reducer<T> {
  public abstract createDispatcher(): Dispatcher<T>;

  public reduce(action: Action<T>): ActionResult<T> {
    const dispatcher = this.createDispatcher();
    return dispatcher.dispatch(action);
  }
}
