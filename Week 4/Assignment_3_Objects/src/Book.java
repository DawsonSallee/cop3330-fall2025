// Dawson Sallee
// Assignment 3
// COP 3330


public class Book {

    private String title; // The title of the book.
    private String author; // The name of the author.
    private String isbn; // The unique ISBN number.
    private boolean isAvailable; // A flag indicating if the book is available.

    public Book() {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.isAvailable = true;
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    //Accessor Methods
    public String getTitle() {
        return "";
    }

    public String getAuthor() {
        return "";
    }

    public String getIsbn() {
        return "";
    }

    public boolean isAvailable() {
        return false;
    }

    //Mutator Methods
    public void setTitle(String title) {

    }

    public void setAuthor(String author) {

    }

    public void setIsbn(String isbn) {

    }

    //Utility Methods
    public void checkout() {

    }

    public void returnBook() {

    }

    public String getDescription() {
        return "";
    }
}