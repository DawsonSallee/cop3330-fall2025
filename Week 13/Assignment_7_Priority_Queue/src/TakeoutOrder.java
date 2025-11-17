// Dawson Sallee
// Assignment 7
// COP3330

/**
 * Represents a specific type of food order: a Takeout Order.
 * This class extends {@link FoodOrder} and provides a concrete implementation
 * for the abstract {@code prepareOrder()} method, specific to takeout orders.
 */
public class TakeoutOrder extends FoodOrder {

    public TakeoutOrder(String customerName, String item, int priority) {
        super(customerName, item, priority);
    }

    @Override
    public void prepareOrder() {

        System.out.println("Preparing takeout order for " + getCustomerName() + ": " + getItem());

    }
    
}
