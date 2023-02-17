package bead.ex.FactoryMethod;


import bead.ex.FactoryMethod.enums.ActionType;
import bead.ex.FactoryMethod.models.Action;
import bead.ex.FactoryMethod.reducers.Reducer;
import bead.ex.FactoryMethod.reducers.impl.StringReducer;

public class FactoryMethod {
  public static void main(String[] args) {
    Reducer<String> reducer = new StringReducer();
    Action<String> action = new Action<>(ActionType.DELETE, "DELETE ACTION");
    System.out.println(reducer.reduce(action).getPayload());
  }
}
