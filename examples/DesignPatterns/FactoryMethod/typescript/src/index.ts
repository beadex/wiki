import { Action } from './models';
import { Reducer, StringReducer } from './reducers';

const stringReducer: Reducer<string> = new StringReducer();
const action: Action<string> = new Action('GET', 'GET DISPATCH');
console.log(stringReducer.reduce(action));
