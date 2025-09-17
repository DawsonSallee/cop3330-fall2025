import java.util.ArrayList;

public class Q3 {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(4);
        list.add(20);

        int largest = findLargest(list);
        System.out.printf("%d", largest);
    }

    public static Integer findLargest(ArrayList<Integer> list) {

        Integer largest = list.get(0);

        for(int i = 0; i < list.size(); i++) {
            if(largest < list.get(i))
                largest = list.get(i);
        }

        return largest;
    }
}