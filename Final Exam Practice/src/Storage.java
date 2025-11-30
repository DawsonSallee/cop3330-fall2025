public class Storage<T> {
    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T peek() {
        return this.item;
    } 

    public static void main(String[] args) {
        Storage<String> thing = new Storage<>();
        thing.put("hello");
        System.out.println(thing.peek());
    }
}