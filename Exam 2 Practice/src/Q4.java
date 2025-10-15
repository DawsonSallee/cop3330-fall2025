import java.util.LinkedList;
import java.util.Queue;

public class Q4 {

    Queue<String> orders = new LinkedList<>();

    public void placeOrder(String orderID) {
        orders.add(orderID);
    }

    public String fufillNextOrder() {
        if(orders.isEmpty())
            return "No Orders to fulfill";
        
        return orders.remove();
    }

    public String checkNextOrder() {
        if(orders.isEmpty())
            return "Queue is empty";

        return orders.peek();
    }

}
