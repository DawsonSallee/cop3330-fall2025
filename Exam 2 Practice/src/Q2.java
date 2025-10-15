import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Q2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println("Enter a file name: ");

        userInput = scanner.nextLine();

        try(PrintWriter pw = new PrintWriter(new FileWriter(userInput))) {
            
            pw.println("5");
            pw.println("18");

        } catch(IOException e) {
            System.out.println("file not found");
        }

        File file = new File(userInput);

        try (Scanner scanner2 = new Scanner(file)) {

            int total = 0;

            while(scanner2.hasNextInt()) {
                total += scanner2.nextInt();
            }

            System.out.println("The total is: " + total);

        } catch(FileNotFoundException e) {
            System.out.println("file not found");
        }

        scanner.close();

    }
}