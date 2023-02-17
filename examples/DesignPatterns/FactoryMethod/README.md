# Factory Method

**Fac­to­ry Method** là một Cre­ation­al Design Pat­tern cung cấp một inter­face nhằm mục đích khởi tạo các object trong một super­class, nhưng cho phép các sub­class­ có khả năng thay đổi kiểu (type) của các object sẽ được khởi tạo.

## Pseudocode & Phân tích

Giờ hãy tưởng tượng như này: Một nhà máy (`Factory`) sẽ sản xuất ra một sản phẩm (`Product`), và cho rằng sản phẩm này phải tuân thủ theo một thiết kế về mặt chức năng nhất định (implements từ một interface duy nhất), đồng nghĩa với việc chúng có thể có các giá trị thuộc tính khác nhau, nhưng phải có cách tính năng giống y hệt nhau (nhưng việc khác nhau về thuộc tính có thể cho ra cách vận hành tính năng khác nhau, tuy nhiên số lượng tính năng thì như nhau!).

Ta gọi những class dưới đây là product class.

```
interface Dispatcher<T> is
    method dispatch(action<T>)

class StringDispatcher implements Dispatcher<string> is
    field dispatcherID
    method dispatch(action<string>) is
        // Define how to dispatch a string action's payload...

class NumberDispatcher implements Dispatcher<number> is
    field dispatcherID
    method dispatch(action<number>) is
        // Define how to dispatch a number action's payload...
```

Đảm bảo tất cả các sản phẩm cụ thể (`StringDispatcher`, `NumberDispatcher`,...) implements chung một interface (`Dispatcher`). Tại interface này, define các method có ý nghĩa với mọi sản phẩm cụ thể.

Dưới đây được gọi là một creator class. Trong class này phải define một method trả ra một product object. Thông thường các subclass sẽ có vai trò cung cấp implementation cho method này, tuy nhiên nó cũng có thể tự cung cấp default implementation.

```
abstract class Reducer<T> is
    abstract method createDispatcher(): Dispatcher<T>
    method reduce() is
        Dispatcher<T> dispatcher = this.createDispatcher()
        dispatcher.dispatch()
```

Mặc dù được gọi là creator class, tuy nhiên vai trò chính của class này không phải để tạo ra các product object. Chúng thường chứa các core business logic hoạt động dựa trên hành vi của các product object được trả ra từ factory method.

```
class StringReducer extends Reducer<string> is
    override method createDispatcher(): Dispatcher<string> is
        return new StringDispatcher(dispatcherID)

class NumberReducer extends Reducer<number> is
    override method createDispatcher(): Dispatcher<number> is
        return new NumberDispatcher(dispatcherID)
```

Các subclass của creator class có thể thay đổi gián tiếp các business logic này bằng cách override factory method và trả ra các type khác nhau của product object.

To be update...!