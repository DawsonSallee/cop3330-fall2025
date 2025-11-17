// Dawson Sallee
// Assignment 7
// COP3330

import java.util.PriorityQueue;

/**
 * An abstract base class representing a generic food order in the restaurant system.
 * It encapsulates common properties shared by all types of orders (customer name, item, priority)
 * and defines the fundamental behavior for preparing an order.
 * This class implements the {@link Comparable} interface to define the natural
 * ordering of {@code FoodOrder} objects, which is crucial for the {@link PriorityQueue}
 * to correctly manage orders.
 */
public abstract class FoodOrder implements Comparable<FoodOrder> {

    private String customerName;    // The name of the customer placing the order.
    private String item;            // The specific food item being ordered (e.g., "Burger", "Sushi").
    private int priority;           // The priority level of the order (lower number means higher priority).

    public FoodOrder(String customerName, String item, int priority) {

        this.customerName = customerName;
        this.item = item;
        this.priority = priority;
    }
    /**
     * An abstract method that defines the behavior for preparing a specific type of food order.
     * Subclasses (e.g., DineInOrder, TakeoutOrder) must provide their own concrete implementation
     * of this method, specifying how each order type's preparation message is displayed.
     */
    public abstract void prepareOrder();

    // --- Getter Methods ---

    public String getCustomerName() {
        return this.customerName;
    }

    public String getItem() {
        return this.item;
    }

    public int getPriority() {
        return this.priority;
    }

    /**
     * Compares this FoodOrder object with another FoodOrder object for order.
     * This method implements the natural ordering of FoodOrder objects, which is
     * essential for the {@link PriorityQueue} to function correctly.
     */
    @Override
    public int compareTo(FoodOrder other) {

        if(this.priority > other.priority) {
            return 1;
        } else if(this.priority < other.priority) {
            return -1;
        }

        int itemComparision = this.item.compareTo(other.item);

        if(itemComparision != 0) {
            return itemComparision;
        }

        return this.customerName.compareTo(other.customerName);
    }
}