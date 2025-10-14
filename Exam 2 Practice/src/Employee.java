public abstract class Employee {
    private int id;
    private String name;
    
    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.id;
    }
    
    public abstract double calculateMonthlySalary();

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}