import { Action } from './Action';
import { ActionType } from './ActionType';

export class ActionResult<T> extends Action<T> {
  private _dispatcherID: number;

  constructor(type: ActionType, payload: T, dispatcherID: number) {
    super(type, payload);
    this._dispatcherID = dispatcherID;
  }

  public get dispatcherID(): number {
    return this._dispatcherID;
  }
  public set dispatcherID(value: number) {
    this._dispatcherID = value;
  }
}
