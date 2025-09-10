// Dawson Sallee
// Assignment 3
// COP 3330

/**
 * Represents a single book in a library system.
 * This class encapsulates a book's details, such as its title, author, ISBN,
 * and its current availability status.
 */
public class Book {

    // --- Instance Variables ---
    // These variables hold the state for each individual Book object.
    private String title; // The title of the book.
    private String author; // The name of the author.
    private String isbn; // The unique ISBN number.
    private boolean isAvailable; // A flag indicating if the book is available.

    /**
     * Default constructor.
     * Initializes a new Book with empty string details and sets its status to available.
     */
    public Book() {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.isAvailable = true;
    }

    /**
     * Parameterized constructor.
     * Initializes a new Book with the provided details.
     * The book is automatically set to available upon creation.
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     * @param isbn   The unique ISBN of the book.
     */
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    // --- Accessor (getter) Methods ---

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    // --- Mutator (setter) Methods ---

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // --- Utility Methods ---

    /**
     * Marks the book as checked out by setting its availability to false.
     */
    public void checkout() {
        this.isAvailable = false;
    }

    /**
     * Marks the book as returned by setting its availability to true.
     */
    public void returnBook() {
        this.isAvailable = true;
    }


    /**
     * Generates a formatted, human-readable string containing all the details of the book.
     *
     * @return A descriptive string representation of the book's current state.
     */
    public String getDescription() {

        String availablity; // A temporary variable to hold the status text.

        // This block determines the correct display text based on the isAvailable flag.
        if(this.isAvailable()) {
            availablity = "(Available)";
        }
        else {
            availablity = "(Checked Out)";
        }

        // Construct the final description string by concatenating all the book's details.
        String description = "Title: " + this.getTitle() + ", Author: " + this.getAuthor() + ", ISBN: " + this.getIsbn() + " " + availablity;
        return description;
    }
}