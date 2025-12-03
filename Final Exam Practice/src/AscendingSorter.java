import java.util.*;

public class AscendingSorter implements DataProcessor{
    
    public static void main(String[] args) {

        ArrayList<Integer> data = new ArrayList<>();

        data.add(5);
        data.add(7);

        DataProcessor sorter = new AscendingSorter();

        sorter.processData(data);

        for(Integer i : data) {
            System.out.println(i);
        }
    }

    @Override
    public List<Integer> processData(List<Integer> data) {
        
        Collections.sort(data);
        return data;
    }
}
