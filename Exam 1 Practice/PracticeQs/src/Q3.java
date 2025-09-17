import java.util.ArrayList;

public class Q3 {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(4);
        numbers.add(3);

        int largestNumber = findLargest(numbers);

        System.out.printf("%d", largestNumber);

    }

    public static int findLargest(ArrayList<Integer> numbers) {

        int currentLargest = numbers.get(0);

        for(int i = 1; i < numbers.size(); i++) {

            if(currentLargest < numbers.get(i)) {
                currentLargest = numbers.get(i);
            }
        }

        return currentLargest;
    }
}