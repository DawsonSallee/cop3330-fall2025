import java.util.ArrayList;
import java.util.List;

public class Q1 {

    public static void main(String[] args) {

        List<Employee> people = new ArrayList<>();

        people.add(new FullTimeEmployee(10,"Dawson", 100000));
        people.add(new Contractor(11,"Lance", 90000));

        System.out.printf("Name: %s Salary: %f\n", people.get(0).getName(), people.get(0).calculateMonthlySalary());
        System.out.printf("Name: %s Salary: %f", people.get(1).getName(), people.get(1).calculateMonthlySalary());
    }
}