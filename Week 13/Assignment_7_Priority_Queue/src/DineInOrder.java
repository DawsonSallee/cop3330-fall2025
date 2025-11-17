// Dawson Sallee
// Assignment 7
// COP3330

/**
 * Represents a specific type of food order: a Dine-In Order.
 * This class extends {@link FoodOrder} and provides a concrete implementation
 * for the abstract {@code prepareOrder()} method, specific to dine-in orders.
 */
public class DineInOrder extends FoodOrder {

    public DineInOrder(String customerName, String item, int priority) {

        super(customerName, item, priority);
    }

    @Override
    public void prepareOrder() {

        System.out.println("Preparing dine-in order for " + getCustomerName() + ": " + getItem());

    }
}