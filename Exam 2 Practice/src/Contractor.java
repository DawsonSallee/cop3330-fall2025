public class Contractor extends Employee {
    private double hourlyRate;

    public Contractor(int id, String name, double hourlyRate) {
        super(id,name);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateMonthlySalary() {
        return hourlyRate*160;
    }
}
