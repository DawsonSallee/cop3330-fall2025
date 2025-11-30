import java.util.*;

public class Itr {
    public static void main(String[] args) {
        List<String> letters = new ArrayList<>();

        letters.add("A");
        letters.add("B");
        letters.add("C");

        Iterator<String> lettersItr = letters.iterator();

        while(lettersItr.hasNext()) {
            if(lettersItr.next().equals("B")) {
                lettersItr.remove();
            }
        }

        for(String s : letters) {
            System.out.println(s);
        }
    }
}
