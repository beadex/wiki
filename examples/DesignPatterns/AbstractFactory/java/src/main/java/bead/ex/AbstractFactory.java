package bead.ex;

import bead.ex.models.dispatchers.Action;
import bead.ex.models.dispatchers.ActionType;
import bead.ex.models.dispatchers.Dispatcher;
import bead.ex.models.listeners.EventType;
import bead.ex.models.listeners.Listener;
import bead.ex.reducers.Reducer;
import bead.ex.reducers.impl.ClosureEventReducer;

public class AbstractFactory {
    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equals("--watch-closure-event")) {
                Reducer reducer = new ClosureEventReducer();
                Dispatcher dispatcher = reducer.createDispatcher();
                Listener listener = reducer.createListener(EventType.ADD);
                System.out.println(dispatcher.dispatch(new Action(ActionType.READ, "SET SELECT ALL")).getPayload());
                System.out.println(listener.listen("5555").getType());
            }
        } else {
            System.out.println("Need arguments");
        }
    }
}