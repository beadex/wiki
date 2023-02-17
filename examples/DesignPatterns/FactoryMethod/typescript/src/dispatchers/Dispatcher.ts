import { Action, ActionResult } from '../models';

export interface Dispatcher<T> {
  dispatch(action: Action<T>): ActionResult<T>;
}
