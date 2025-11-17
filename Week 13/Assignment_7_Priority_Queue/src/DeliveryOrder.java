// Dawson Sallee
// Assignment 7
// COP3330

/**
 * Represents a specific type of food order: a Delivery Order.
 * This class extends {@link FoodOrder} and provides a concrete implementation
 * for the abstract {@code prepareOrder()} method, specific to delivery orders.
 */
public class DeliveryOrder extends FoodOrder {

    public DeliveryOrder(String customerName, String item, int priority) {
        super(customerName, item, priority);
    }

    @Override
    public void prepareOrder() {

        System.out.println("Preparing delivery order for " + getCustomerName() + ": " + getItem());

    }
}