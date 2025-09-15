
public class Q4 {

    private String title;
    private String author;

    public Q4(String title, String author) {

        this.title = title;
        this.author = author;

    }

    public void displayBookInfo() {
        System.out.printf("Title: %s, Author: %s", this.title, this.author);
    }
    public static void main(String[] args) {

        Q4 book = new Q4("Bob", "Daddy D");
        book.displayBookInfo();

    }
}