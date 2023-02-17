import { ActionType } from './ActionType';

export class Action<T> {
  private _type: ActionType;
  private _payload: T;

  constructor(type: ActionType, payload: T) {
    this._type = type;
    this._payload = payload;
  }

  public get type(): ActionType {
    return this._type;
  }

  public set type(type: ActionType) {
    this._type = type;
  }

  public get payload(): T {
    return this._payload;
  }
  public set payload(payload: T) {
    this._payload = payload;
  }
}
