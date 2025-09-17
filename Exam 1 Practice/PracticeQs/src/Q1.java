import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence G");
        String userInput = scanner.nextLine();

        printReverseChars(userInput);
        System.out.println("");
        printReverseWords(userInput);
        printWordStats(userInput);
        printNumberOfWordsWithVowels(userInput);

        scanner.close();
    }

    public static void printReverseChars(String line) {

        for(int i = 0; i < line.length(); i++) {
            
            if(line.charAt(line.length()-1-i) != ' ')
                System.out.printf("%c",line.charAt(line.length()-1-i));
        }
    }

    public static void printReverseWords(String line) {

        String[] splitList = line.split(" ");

        for(int i = 0; i < splitList.length; i++) {
            System.out.printf("%s ", splitList[splitList.length - 1 - i]);
        }
    }
    public static void printWordStats(String line) {
        int evenWords = 0;
        int oddWords = 0;

        String[] splitList = line.split(" ");

        for(int i = 0; i < splitList.length; i++) {
            if(splitList[i].length()%2 == 0) {
                evenWords++;
            } else {
                oddWords++;
            }
        }
        
        System.out.printf("\nOdd words = %d, Even words = %d\n", oddWords, evenWords);

    }

    public static void printNumberOfWordsWithVowels(String line) {
        String[] splitList = line.toLowerCase().split(" ");
        int vowelsTotal = 0;

        for(int i = 0; i < splitList.length; i++) {
            for(int j = 0; j < splitList[i].length(); j++) {
                if(splitList[i].charAt(j) == 'a' || splitList[i].charAt(j) =='e' || splitList[i].charAt(j) =='i' || splitList[i].charAt(j) =='o' || splitList[i].charAt(j) =='u') {
                    vowelsTotal++;
                    break;
                }
            }
        }

        System.out.printf("Words with Vowels: %d\n", vowelsTotal);
    }

}