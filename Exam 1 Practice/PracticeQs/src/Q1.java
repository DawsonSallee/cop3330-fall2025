import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a String");

        String userInput = scanner.nextLine();

        printReverseChars(userInput);

        System.out.print("\n");

        printReverseWords(userInput);

        System.out.print("\n");

        printWordStats(userInput);

        System.out.print("\n");

        printNumberOfWordsWithVowels(userInput);

        scanner.close();
    }

    public static void printReverseChars(String line) {

        for(int i = line.length() - 1; i >= 0; i--) {

            if(line.charAt(i) != ' ') {
                System.out.printf("%c", line.charAt(i));
            }
        }

    }

    public static void printReverseWords(String line) {

        String[] words = line.split(" ");

        for(int i = words.length - 1; i >= 0; i--) {

            System.out.printf("%s" + " ", words[i]);
        }
    }

    public static void printWordStats(String line) {

        int evenCounter = 0;
        int oddCounter = 0;

        String[] words = line.split(" ");

        for(int i = 0; i < words.length; i++) {

            if(words[i].length() % 2 == 0) {
                evenCounter++;
            } else {
                oddCounter ++;
            }
        }
        
        System.out.printf("Even Numbers %d and Odd Numbers %d", evenCounter, oddCounter);
    }

    public static void printNumberOfWordsWithVowels(String line) {

        int wordsYesVowels = 0;
        int wordsNoVowels = 0;
        boolean check = false;

        String[] words = line.toLowerCase().split(" ");

        for(int i = 0; i < words.length; i++) {
            check = false;
            for(int j = 0; j < words[i].length(); j++) {

                if(words[i].charAt(j) == 'a' || words[i].charAt(j) == 'e' || words[i].charAt(j) == 'i' || words[i].charAt(j) == 'o' || words[i].charAt(j) == 'u') {
                    check = true;
                }
            }

            if(check) {
                wordsYesVowels++;
            }
            else {
                wordsNoVowels++;
            }
        }
        System.out.printf("Words with Vowels %d and Words without Vowels %d", wordsYesVowels, wordsNoVowels);
    }
}
