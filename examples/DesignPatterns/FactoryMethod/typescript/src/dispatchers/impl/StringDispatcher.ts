import { Action, ActionResult } from '../../models';
import { Dispatcher } from '../Dispatcher';

export class StringDispatcher implements Dispatcher<string> {
  private _dispatcherID: number;

  constructor(dispatcherID: number) {
    this._dispatcherID = dispatcherID;
  }

  public dispatch(action: Action<string>): ActionResult<string> {
    return new ActionResult(action.type, action.payload, this._dispatcherID);
  }

  public get dispatcherID(): number {
    return this._dispatcherID;
  }
  public set dispatcherID(value: number) {
    this._dispatcherID = value;
  }
}
