// Dawson Sallee
// Assignment 1
// COP 3330

import java.util.Scanner;


public class EventInvitation {
    public static void main(String[] args) {

        // use scanner to grab the invitation data

        System.out.println("--- Event Invitation Generator ---\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Event Name: ");
        String eventName = scanner.nextLine();
        
        System.out.print("Enter the Event Date: ");
        String eventDate = scanner.nextLine();

        System.out.print("Enter the Event Time: ");
        String eventTime = scanner.nextLine();

        System.out.print("Enter the Event Location: ");
        String eventLocation = scanner.nextLine();

        System.out.print("Enter the Host's Name: ");
        String hostName = scanner.nextLine();

        System.out.print("Enter the Guest's Name: ");
        String guestName = scanner.nextLine();


        // print out the invitation with the collected data

        System.out.println("");
        System.out.println("--- Your Personalized Invitation ---\n");

        System.out.println("You're Invited!\n");

        System.out.printf("Event:\t\t%s\n", eventName);
        System.out.printf("Date:\t\t%s\n", eventDate);
        System.out.printf("Time:\t\t%s\n", eventTime);
        System.out.printf("Location:\t%s\n", eventLocation);

        System.out.printf("Hosted by:\t%s\n\n", hostName);
        System.out.printf("Dear %s,\n", guestName);
        System.out.print("We'd be thrilled to have you join us for a wonderful time!\n");

        scanner.close();
    }
}