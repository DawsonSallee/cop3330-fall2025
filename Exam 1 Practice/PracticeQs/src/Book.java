
public class Book {

    private String title;
    private String author;

    public static void main(String[] args) {

        Book book1 = new Book("Papi", "Dawson");
        book1.displayBookInfo();

    }

    public Book (String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayBookInfo() {
        System.out.printf("Title %s, Author %s", title, author);
    }
}