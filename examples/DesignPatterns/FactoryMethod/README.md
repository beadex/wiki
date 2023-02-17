# Factory Method

**Fac­to­ry Method** là một Cre­ation­al Design Pat­tern cung cấp một inter­face nhằm mục đích khởi tạo các object trong một super­class, nhưng cho phép các sub­class­ có khả năng thay đổi kiểu (type) của các object sẽ được khởi tạo.

## Phân tích ví dụ

```java
interface Dispatcher<T> {
    ActionResult<T> dispatch(Action<T> action);
}
```

Giả dụ chúng ta có một interface `Dispatcher` có một method `dispatch` mà ở đó nó nhận vào một object `Action`

```java
class Action<T> {
    private ActionType type;
    private T payload;
}
```
và trả ra một object `ActionResult`
```java
class ActionResult<T> extends Action<T> {
    private int dispatcherID;
}
```
Bản chất của `ActionResult` được extends từ `Action`, một `ActionResult` sẽ có `type` và `payload` của `Action` vừa được `dispatch` cùng với `ID` của `Dispatcher` thực hiện hành động đó.

Nhớ rằng các interface/class này đều có generic type dành cho `payload` của `Action`.

Ở trong ví dụ này chúng ta implements 2 object `Dispatcher` chính là `StringDispatcher` và `IntegerDispatcher`, đồng nghĩa với type nhận vào của `Action.payload` là `String` và `Integer`.

```java
public class StringDispatcher implements Dispatcher<String> {
    private int dispatcherID;

    public StringDispatcher(int dispatcherID) {
        this.dispatcherID = dispatcherID;
    }

    @Override
    public ActionResult<String> dispatch(Action<String> action) {
        return new ActionResult<>(action.getType(), action.getPayload(), this.dispatcherID);
    }

    public int getDispatcherID() {
        return dispatcherID;
    }

    public void setDispatcherID(int dispatcherID) {
        this.dispatcherID = dispatcherID;
    }
}
```
```java
public class IntergerDispatcher implements Dispatcher<Integer> {
    private int dispatcherID;

    public IntergerDispatcher(int dispatcherID) {
        this.dispatcherID = dispatcherID;
    }

    @Override
    public ActionResult<Integer> dispatch(Action<Integer> action) {
        return new ActionResult<>(action.getType(), action.getPayload(), this.dispatcherID);
    }

    public int getDispatcherID() {
        return dispatcherID;
    }

    public void setDispatcherID(int dispatcherID) {
        this.dispatcherID = dispatcherID;
    }
}
```

Giờ đây chúng ta đã có các đối tượng `Dispatcher`, việc tiếp theo cần làm là sử dụng method duy nhất của chúng là `dispatch`. Tạm gọi đối tượng sẽ đảm nhiệm việc execute `dispatch` của `Dispatcher` là một `Reducer`.

```java
public interface Reducer<T> {
  ActionResult<T> reduce(Action<T> action);
}
```

Method `reduce` sẽ có nhiệm vụ tạo ra `Dispatcher` với type tương ứng và call method `dispatch` của `Dispatcher` đó, implement như sau:

```java
@Override
public ActionResult<T> reduce(Action<T> action) {
    Dispatcher<T> dispatcher = createDispatcher();
    return dispatcher.dispatch(action);
}
```

Triển khai method `createDispatcher` thông qua một implement của `Reducer` có tên là `ReducerCreator`.
```java
abstract class ReducerCreator<T> implements Reducer<T> {
    public abstract Dispatcher<T> createDispatcher();

    @Override
    public ActionResult<T> reduce(Action<T> action) {
        Dispatcher<T> dispatcher = createDispatcher();
        return dispatcher.dispatch(action);
    }
}
```

Hiện tại chúng ta đã có abstract class được gọi là `Factory` sẵn sàng cho việc implements cách thay đổi kiểu object được khởi tạo dựa trên type của `Reducer`. Ở đây dựa theo 2 hai loại `Dispatcher` define ở trên, chúng ta có 2 `Reducer` tương ứng.
```java
class StringReducer extends ReducerCreator<String> {
    private final Random rand = new Random();
    @Override
    public Dispatcher<String> createDispatcher() {
        return new StringDispatcher(rand.nextInt(255));
    }
}
```
```java
class IntegerReducer extends ReducerCreator<Integer> {
    private final Random rand = new Random();
    @Override
    public Dispatcher<Integer> createDispatcher() {
        return new IntergerDispatcher(rand.nextInt(255));
    }
}
```

Hiện tại, ta có thể có được cách sử dụng các `Factory` như sau:
```java
Reducer<String> reducer = new StringReducer();
Action<String> action = new Action<>(ActionType.DELETE, "DELETE ACTION");
reducer.reduce(action);
```

...To be update!