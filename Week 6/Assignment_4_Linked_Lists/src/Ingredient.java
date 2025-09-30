public class Ingredient {

    private String name;
    private int power = 0;

    public Ingredient(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return this.name;
    }

    public int getPower() {
        return this.power;
    }
}
