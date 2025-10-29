import java.util.*;

public class DataStructures {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Stack<String> list1 = new Stack<>();
        Queue<String> list2 = new LinkedList<>();
        List<String> list3 = new LinkedList<>();
        Queue<String> list4 = new PriorityQueue<>();

        list.get(1);
        list.add(1, "car");
        list.size();
        list.remove(5);

        list1.pop();
        list1.peek();
        list1.isEmpty();
        list1.push("a");

    }
}
