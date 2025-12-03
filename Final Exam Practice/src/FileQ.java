import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class FileQ {
    public static void main(String[] args) {
        addFileIntegers();
        System.out.println(sumFileIntegers());
    }
    
    public static int sumFileIntegers() {
        int total = 0;

        try {
            Scanner fileReader = new Scanner(new File("nums.txt"));

            while(fileReader.hasNext()) {
                total += fileReader.nextInt(); 
            }

            fileReader.close();

        } catch  (FileNotFoundException e) {
            System.out.println(e);
        } 

        return total;
    }

    public static void addFileIntegers() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("nums.txt"));
            pw.println("5");
            pw.println("8");
            pw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
