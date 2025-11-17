// Dawson Sallee
// Assignment 7
// COP3330

public class DineInOrder extends FoodOrder {

    public DineInOrder(String customerName, String item, int priority) {

        super(customerName, item, priority);
    }

    @Override
    public void prepareOrder() {

        System.out.println("Preparing dine-in order for " + getCustomerName() + ": " + getItem());

    }
}