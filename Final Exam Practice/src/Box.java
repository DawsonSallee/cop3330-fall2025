public class Box<T> {

    T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return this.content;
    }
}