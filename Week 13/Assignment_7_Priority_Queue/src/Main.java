// Dawson Sallee
// Assignment 7
// COP3330

import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Main class for the Restaurant Order Handler system.
 * This program reads commands from an input file, manages food orders using a PriorityQueue,
 * and processes orders based on their priority. It supports INSERT and PREPARE commands.
 * The input file is searched for in a specific order: a7a.txt, then a7b.txt, then a7c.txt.
 */
public class Main {

    public static void main(String[] args) {
        
        Scanner fileScanner = null;

        // Attempts to open input files in a specific order: a7a.txt, then a7b.txt, then a7c.txt.
        // If one is found, it's opened and used. If none are found, the program terminates.
        try {

            fileScanner = new Scanner(new File("a7a.txt"));

        } catch(FileNotFoundException e1) {

            try {

                fileScanner = new Scanner(new File("a7b.txt"));

            } catch(FileNotFoundException e2) {

                try {

                    fileScanner = new Scanner(new File("a7c.txt"));

                } catch(FileNotFoundException e3) {

                    System.out.println("Input files do not exist");
                    return; // ends the program since exits main
                }
            }
        }


        PriorityQueue<FoodOrder> queue = new PriorityQueue<>();
        
        FoodOrder newOrder = null;
        
        // The first line of the file contains an integer, N, representing the total number of commands.
        int numOperations = fileScanner.nextInt();
        fileScanner.nextLine(); // CONSUME THE LEFTOVER NEWLINE character after nextInt()

        String line;        // Stores the entire line read from the file
        String[] words;     // Stores parts of the line after splitting by space
        String command;     // Stores the first word of the line (e.g., "INSERT" or "PREPARE")

        String type;        // Specific order type (e.g., "TAKEOUT", "DINEIN")
        String customerName;
        String item;
        int priority;

        
        // Iterates through the file, processing each command as specified by numOperations.
        for(int i = 0; i < numOperations; i++) {
            
            line = fileScanner.nextLine();
            words = line.split(" ");
            command = words[0];

            if(command.equals("INSERT")) {

                // Parse the details for the new order from the 'words' array
                type = words[1];
                customerName = words[2];
                item = words[3];
                priority = Integer.parseInt(words[4]);

                // Reset newOrder for each iteration to avoid using a stale object
                newOrder = null; 

                switch(type) {
                    case "TAKEOUT":

                        newOrder = new TakeoutOrder(customerName, item, priority);
                        break;

                    case "DELIVERY":

                        newOrder = new DeliveryOrder(customerName, item, priority);
                        break;

                    case "DINEIN":

                        newOrder = new DineInOrder(customerName, item, priority);
                        break;
                }

                if (newOrder != null) {
                    queue.add(newOrder);
                } 
            } else if (command.equals("PREPARE")) {
                if (!queue.isEmpty()) {

                    FoodOrder nextOrder = queue.poll();
                    nextOrder.prepareOrder();

                }
            }
        }
        fileScanner.close();
    }
}
