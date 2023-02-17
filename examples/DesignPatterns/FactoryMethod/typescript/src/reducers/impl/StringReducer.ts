import { random } from 'lodash';
import { Dispatcher, StringDispatcher } from '../../dispatchers';
import { Reducer } from '../Reducer';

export class StringReducer extends Reducer<string> {
  public createDispatcher(): Dispatcher<string> {
    return new StringDispatcher(random(1, 255));
  }
}
