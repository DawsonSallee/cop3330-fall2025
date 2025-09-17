import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int userInput;
        int totalEntries = 0;
        int total = 0;

        System.out.println("Enter numbers brotha");

        while(true) {
            
            userInput = keyboard.nextInt();
            
            if(userInput != 0) {
                total += userInput;
                totalEntries++;
            } else {
                break;
            }
        }
        System.out.printf("Average %f", (double) total / totalEntries);
        keyboard.close();
    }
}