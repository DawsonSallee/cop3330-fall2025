// Dawson Sallee
// Assignment 3
// COP 3330

import java.util.ArrayList;

/**
 * The main driver class for the library application.
 * This class is responsible for creating Book objects, managing them in a collection,
 * and printing their details to the console to demonstrate functionality.
 */
public class KnightLibrary {

    /**
     * The main entry point for the program.
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        
        // Create an ArrayList to act as a "bookcase" for storing Book objects.
        ArrayList<Book> bookcase =  new ArrayList<>();

        // --- STEP 1: Object Instantiation ---
        // Create three distinct Book objects. One with the default constructor
        // and two with the parameterized constructor.
        Book book1 = new Book();
        Book book2 = new Book("Dune", "Frank Herbert", "978-0-441-17271-9");
        Book book3 = new Book("1984", "George Orwell", "978-0-451-52493-5");

        // --- STEP 2: Add Books to the Collection ---
        // Add the newly created Book objects into the ArrayList.
        bookcase.add(book1);
        bookcase.add(book2);
        bookcase.add(book3);

        // --- STEP 3: Manipulate the Objects ---
        // Use setter methods to populate the details for the first book,
        // which was created with the default constructor.
        bookcase.get(0).setTitle("The Hitchhiker's Guide to the Galaxy");
        bookcase.get(0).setAuthor("Douglas Adams");
        bookcase.get(0).setIsbn("978-0-345-39180-3");

        // Perform checkout and return operations as required by the assignment.
        // Get the second book (at index 1) and check it out.
        bookcase.get(1).checkout();
        // Get the third book (at index 2) and "return" it.
        bookcase.get(2).returnBook();

        // --- STEP 4: Verification ---
        // Print the status of each book to the console to verify that the
        // methods and state changes worked correctly.
        System.out.println("Book 1 Details:");
        System.out.printf("%s\n", bookcase.get(0).getDescription());
        System.out.println("------------------------");

        System.out.println("Book 2 Details:");
        System.out.printf("%s\n", bookcase.get(1).getDescription());
        System.out.println("------------------------");

        System.out.println("Book 3 Details:");
        System.out.printf("%s\n", bookcase.get(2).getDescription());
        System.out.println("------------------------");
    }
}
