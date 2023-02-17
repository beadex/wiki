package bead.ex.FactoryMethod.reducers;

import bead.ex.FactoryMethod.dispatchers.impl.IntergerDispatcher;
import bead.ex.FactoryMethod.dispatchers.impl.StringDispatcher;
import bead.ex.FactoryMethod.enums.ActionType;
import bead.ex.FactoryMethod.models.Action;
import bead.ex.FactoryMethod.models.ActionResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

@SuppressWarnings("unchecked")
@RunWith(MockitoJUnitRunner.class)
class ReducerCreatorTest {
    private Action<String> stringAction;
    private Action<Integer> integerAction;
    private int dispatcherID;

    @Mock
    private ReducerCreator<String> stringReducerCreator;

    @Mock
    private ReducerCreator<Integer> integerReducerCreator;

    @BeforeEach
    public void setUp() {
        Random rand = new Random();
        this.stringAction = new Action<>(ActionType.GET, "DO GET * FROM STORE");
        this.integerAction = new Action<>(ActionType.CREATE, 1);
        this.dispatcherID = rand.nextInt(255);

        this.stringReducerCreator = Mockito.mock(ReducerCreator.class);
        this.integerReducerCreator = Mockito.mock(ReducerCreator.class);
    }

    @Test
    void testStringReducerCreator() {
        Mockito.when(this.stringReducerCreator.createDispatcher()).thenReturn(new StringDispatcher(dispatcherID));
        Mockito.doCallRealMethod().when(this.stringReducerCreator).reduce(this.stringAction);

        ActionResult<String> actionResult = this.stringReducerCreator.reduce(this.stringAction);

        System.out.println("--- String Reducer ---");
        System.out.println("Dispatcher ID: " + actionResult.getDispatcherID());
        System.out.println("Action type: " + actionResult.getType());
        System.out.println("Action payload: " + actionResult.getPayload());

        Assertions.assertEquals(dispatcherID, actionResult.getDispatcherID());
        Assertions.assertEquals(ActionType.GET, actionResult.getType());
        Assertions.assertEquals("DO GET * FROM STORE", actionResult.getPayload());
    }

    @Test
    void testIntegerReducerCreator() {
        Mockito.when(this.integerReducerCreator.createDispatcher()).thenReturn(new IntergerDispatcher(dispatcherID));
        Mockito.doCallRealMethod().when(this.integerReducerCreator).reduce(this.integerAction);

        ActionResult<Integer> actionResult = this.integerReducerCreator.reduce(this.integerAction);

        System.out.println("--- Integer Reducer ---");
        System.out.println("Dispatcher ID: " + actionResult.getDispatcherID());
        System.out.println("Action type: " + actionResult.getType());
        System.out.println("Action payload: " + actionResult.getPayload());

        Assertions.assertEquals(dispatcherID, actionResult.getDispatcherID());
        Assertions.assertEquals(ActionType.CREATE, actionResult.getType());
        Assertions.assertEquals(1, actionResult.getPayload());
    }
}