// Dawson Sallee
// Assignment 7
// COP3330

public class TakeoutOrder extends FoodOrder {

    public TakeoutOrder(String customerName, String item, int priority) {
        super(customerName, item, priority);
    }

    @Override
    public void prepareOrder() {

        System.out.println("Preparing takeout order for " + getCustomerName() + ": " + getItem());

    }
    
}
