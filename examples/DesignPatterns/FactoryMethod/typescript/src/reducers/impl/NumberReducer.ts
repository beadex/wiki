import { random } from 'lodash';
import { Dispatcher, NumberDispatcher } from '../../dispatchers';
import { Reducer } from '../Reducer';

export class NumberReducer extends Reducer<number> {
  public createDispatcher(): Dispatcher<number> {
    return new NumberDispatcher(random(1, 255));
  }
}
