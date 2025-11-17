// Dawson Sallee
// Assignment 6
// COP3330

public abstract class FoodOrder implements Comparable<FoodOrder> {

    private String customerName;
    private String item;
    private int priority;

    public FoodOrder(String customerName, String item, int priority) {

        this.customerName = customerName;
        this.item = item;
        this.priority = priority;
    }

    public abstract void prepareOrder();

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