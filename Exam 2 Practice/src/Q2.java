import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Q2 {
    public static void main(String[] args) {

        System.out.println("Enter file name: ");

        Scanner scanner = new Scanner(System.in);

        String fileName = scanner.nextLine();

        try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            pw.println("5");
            pw.println("10");
            pw.println("12");
        }catch(IOException e) {
            System.out.println("error");
        }

        try(Scanner scanner2 = new Scanner(new File(fileName))) {

            int total = 0;

            while(scanner2.hasNextInt()) {
                total += scanner2.nextInt();
            }

            System.out.println(total);

        } catch(FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        scanner.close();
    }
}