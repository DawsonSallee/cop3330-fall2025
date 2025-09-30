import java.util.LinkedList;
import java.util.Scanner;

public class Potion {

    private LinkedList<Ingredient> ingredients;

    private static int potionCounter = 0;

    public Potion(Ingredient ingredient) {

        this.ingredients = new LinkedList<>();
        this.ingredients.add(ingredient);
        potionCounter++;

    }

    public Potion() {

        this.ingredients = new LinkedList<>();
        potionCounter++;

    }

    public void addIngredient(String name, int power) {
        
        this.ingredients.add(new Ingredient(name, power));

    }

    public void addIngredient(String name, int power, int quantity) {

        for(int i = 0; i < quantity; i++) {

            this.ingredients.add(new Ingredient(name, power));

        }
    }

    public void addManyMixed(LinkedList<Ingredient> newIngredients) {

        for(int i = 0; i < newIngredients.size(); i++) {
            this.ingredients.add(newIngredients.get(i));
        }
    }

    public double calculateValue() {

        double value = 50;

        for(int i = 0; i < this.ingredients.size(); i++) {

            value += this.ingredients.get(i).getName().length() * 0.25;

            value += this.ingredients.get(i).getPower() * 1.5;
        }

        return value;
    }

    public void printIngredients() {

        System.out.println("Your Potion contains: ");

        for(int i = 0; i < this.ingredients.size(); i++) {

            System.out.printf("1. %s (Power: %d)\n", this.ingredients.get(i).getName(), this.ingredients.get(i).getPower());
        }

    }

    @Override
    public String toString() {

        int ingredientCount = this.ingredients.size();

        double value = this.calculateValue();
        
        return String.format("This potion contains %d ingredients and is worth $%.2f.", ingredientCount, value);
    }

    public double getPotionCount() {
        return this.potionCounter;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userInput;
        String newIngredient;

        System.out.println("Welcome, Mage. What potion will you craft today?");
        System.out.print("Start with an ingredient? (yes/no): ");

        userInput = scanner.nextLine();

        if(userInput.equals("yes")) {
            
            System.out.println("Enter your first ingredient name and power level (e.g., DragonScale 10): ");

            while(userInput.equals("yes")
        }
        
    }
}
