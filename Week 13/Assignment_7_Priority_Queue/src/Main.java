// Dawson Sallee
// Assignment 7
// COP3330

import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        
        Scanner fileScanner = null;
        FoodOrder newOrder = null;

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

        int numOperations = fileScanner.nextInt();
        fileScanner.nextLine();

        String line;
        String[] words;
        String command;

        String type;
        String customerName;
        String item;
        int priority;

        for(int i = 1; i < numOperations; i++) {
            
            line = fileScanner.nextLine();
            words = line.split(" ");
            command = words[0];

            if(command.equals("INSERT")) {

                type = words[1];
                customerName = words[2];
                item = words[3];
                priority = Integer.parseInt(words[4]);

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
