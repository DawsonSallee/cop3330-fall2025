import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Q2 {
    public static void main(String[] args) {

        System.out.println("Enter file name: ");

        Scanner scanner = new Scanner(System.in);

        String fileName = scanner.nextLine();

        try(Scanner scanner2 = new Scanner(new File(fileName))) {

            int total = 0;

            while(scanner2.hasNextLine()) {
                total += scanner2.nextInt();
            }

            System.out.println(total);

        }catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        scanner.close();
    }
}