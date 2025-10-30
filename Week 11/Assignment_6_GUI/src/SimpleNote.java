// Dawson Sallee
// Assignment 6
// COP3330

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Scanner;

public class SimpleNote extends JFrame {

    // --- INSTANCE VARIABLES ---
    // Declare GUI components as instance variables so they can be accessed
    // by multiple methods (like the constructor and the ActionListener inner class).

    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JButton saveButton;
    private JButton clearButton;
    private JPanel buttonPanel;
    
    private final String FILENAME = "mynote.txt";

    /**
     * The main entry point for the application.
     * Creates an instance of our GUI class, which triggers the constructor to build and show the window.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        SimpleNote note = new SimpleNote();
    }
    
    /**
     * Constructor for the SimpleNote application.
     * This method is responsible for setting up the entire GUI and its initial state.
     */
    public SimpleNote () {

        super();

        // --- 1. CONFIGURE THE MAIN WINDOW (JFRAME) ---
        this.setTitle("SimpleNote");
        this.setSize(400,300);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // --- 2. CREATE THE GUI COMPONENTS ---
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane = new JScrollPane(textArea);
        saveButton = new JButton("Save Note");
        clearButton = new JButton("Clear");

        // --- 3. CREATE A PANEL TO HOLD THE BUTTONS ---
        buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);

        // --- 4. ADD COMPONENTS TO THE JFRAME'S LAYOUT ---
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        

         // --- 5. LOAD THE INITIAL NOTE FROM THE FILE ---
        try(Scanner fileReader = new Scanner(new File(FILENAME))) {
            
            StringBuilder fileContent = new StringBuilder();

            while(fileReader.hasNextLine()) {
                fileContent.append(fileReader.nextLine()).append("\n");
            }

            textArea.setText(fileContent.toString());

        } catch (FileNotFoundException e1) {
            textArea.setText("Welcome! Type your note here.");
        }
        
        // --- 6. REGISTER THE EVENT LISTENER ---
        NoteSaverApp listener = new NoteSaverApp();
        saveButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        
        // --- 7. MAKE THE WINDOW VISIBLE ---
        this.setVisible(true);
    }

    /**
     * A private inner class that handles all button-click events for our GUI.
     * It implements ActionListener, which requires it to have an actionPerformed method.
     * This pattern separates the event-handling logic from the GUI setup logic.
     */
    public class NoteSaverApp implements ActionListener {
            
        /**
         * This single method is called whenever ANY registered component (saveButton or clearButton) is clicked.
         * @param e The ActionEvent object, which contains information about the event, such as its source.
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == saveButton) {
                
                // --- LOGIC FOR THE "SAVE NOTE" BUTTON ---
 
                try(PrintWriter printWriter = new PrintWriter(new FileWriter(FILENAME))) {
                    
                    printWriter.println(textArea.getText());

                    JOptionPane.showMessageDialog(SimpleNote.this, "Note saved successfully!");

                } catch (IOException e2) {
                    System.out.println("An error occurred while writing to the file.");
                }

            } else if (e.getSource() == clearButton) {

                 // --- LOGIC FOR THE "CLEAR" BUTTON ---

                int choice = JOptionPane.showConfirmDialog(
                    SimpleNote.this,
                    "Are you sure you want to clear the note? This cannot be undone.",
                    "Confirm Clear",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );

                if (choice == JOptionPane.YES_OPTION) {
                    textArea.setText("");
                }
            }
        }
    }
}