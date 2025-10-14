public class FullTimeEmployee extends Employee {
    private double annualSalary;

    public FullTimeEmployee(int id, String name, double annualSalary) {

        super(id,name);
        this.annualSalary = annualSalary;
    }

    @Override 
    public double calculateMonthlySalary() {
        return this.annualSalary/12;
    }
}
