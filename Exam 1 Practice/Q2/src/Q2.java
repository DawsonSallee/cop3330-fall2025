import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        
        int userInput = 0;
        int userEntries = 0;
        double userSum = 0.0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Numbers, type 0 when finished");

        while(true) {

            userInput = scanner.nextInt();

            if(userInput == 0)
                break;

            userSum += userInput;
            userEntries++;
        }

        if (userEntries > 0) {
            double average = userSum / userEntries;
            System.out.printf("The average of values entered is: %.2f\n", average); // %.2f formats to 2 decimal places
        } else {
            System.out.println("No valid numbers were entered.");
        }

        scanner.close();
    }
}
