// Dawson Sallee
// Assignment 4
// COP3330

public class Ingredient {

    private String name; //The name of the ingredient
    private int power = 0; // The magical power level of the ingredient

    /**
     * Constructs a new Ingredient object with specified properties.
     * @param name The name of the ingredient (e.g., "DragonScale").
     * @param power The magical power level of the ingredient.
     */
    public Ingredient(String name, int power) {
        this.name = name;
        this.power = power;
    }

    // --- METHODS ---
    /**
     * Public getter to safely retrieve the ingredient's name.
     * @return The name of the ingredient.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Public getter to safely retrieve the ingredient's power level.
     * @return The power level of the ingredient.
     */
    public int getPower() {
        return this.power;
    }
}
