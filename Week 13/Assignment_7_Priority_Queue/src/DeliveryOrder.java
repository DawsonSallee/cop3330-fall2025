// Dawson Sallee
// Assignment 7
// COP3330

public class DeliveryOrder extends FoodOrder {

    public DeliveryOrder(String customerName, String item, int priority) {
        super(customerName, item, priority);
    }

    @Override
    public void prepareOrder() {

        System.out.println("Preparing delivery order for " + getCustomerName() + ": " + getItem());

    }
}