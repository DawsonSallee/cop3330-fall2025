// Dawson Sallee
// Assignment 4
// COP3330

import java.util.LinkedList;
import java.util.Scanner;

public class Potion {

    private LinkedList<Ingredient> ingredients; // A private LinkedList to store Ingredient objects.

    private static int potionCounter = 0;

    // --- CONSTRUCTORS ---
    /**
     * Creates a Potion starting with one ingredient.
     * @param ingredient The initial Ingredient to add to the potion.
     */
    public Potion(Ingredient ingredient) {

        this.ingredients = new LinkedList<>();
        this.ingredients.add(ingredient);
        potionCounter++;

    }
    /**
     * Creates an empty Potion.
     */
    public Potion() {

        this.ingredients = new LinkedList<>();
        potionCounter++;

    }

    // --- METHODS ---
    /**
     * Adds a single new ingredient to the potion's list.
     * @param name The name of the new ingredient.
     * @param power The power of the new ingredient.
     */
    public void addIngredient(String name, int power) {
        
        this.ingredients.add(new Ingredient(name, power));

    }

    /**
     * Adds a specified quantity of the same ingredient.
     * @param name The name of the ingredient to add.
     * @param power The power of the ingredient.
     * @param quantity The number of times to add this ingredient.
     */
    public void addIngredient(String name, int power, int quantity) {

        for(int i = 0; i < quantity; i++) {

            this.ingredients.add(new Ingredient(name, power));

        }
    }

    /**
     * Adds all ingredients from a provided list into this potion's list.
     * @param newIngredients A LinkedList of ingredients to be added.
     */
    public void addManyMixed(LinkedList<Ingredient> newIngredients) {

        for(int i = 0; i < newIngredients.size(); i++) {
            this.ingredients.add(newIngredients.get(i));
        }
    }

    /**
     * Calculates the market value of the potion based on its contents.
     * The formula is a base value plus bonuses for ingredient names and power.
     * @return The calculated value as a double.
     */
    public double calculateValue() {

        double value = 50;

        for(int i = 0; i < this.ingredients.size(); i++) {

            value += this.ingredients.get(i).getName().length() * 0.25;

            value += this.ingredients.get(i).getPower() * 1.5;
        }

        return value;
    }

    /**
     * Prints a user-friendly, numbered list of all ingredients in the potion.
     */
    public void printIngredients() {

        System.out.println("Your Potion contains: ");

        for(int i = 0; i < this.ingredients.size(); i++) {

            System.out.printf("%d. %s (Power: %d)\n", i + 1, this.ingredients.get(i).getName(), this.ingredients.get(i).getPower());
        }

    }

    /**
     * Overrides the default toString() method inherited from the Object class.
     * This provides a custom, formatted string representation of a Potion object.
     * It is automatically called by methods like System.out.println().
     * @return A formatted String summarizing the potion's contents and value.
     */
    @Override
    public String toString() {

        int ingredientCount = this.ingredients.size();

        double value = this.calculateValue();
        
        return String.format("This potion contains %d ingredients and is worth $%.2f.", ingredientCount, value);
    }

    /**
     * A static method to get the total number of potions ever created.
     * Can be called directly on the class: Potion.getPotionCount().
     * @return The current value of the static potionCounter.
     */
    public static int getPotionCount() {
        return potionCounter;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String userfirstChoice;
        String userChoiceType;
        String createAnotherChoice;

        Potion currentPotion;
        String newIngredient;
        int newPower = 0;
        int newQuantity = 0;

        // Outer do-while loop allows the user to create multiple potions.
        do {

            System.out.println("Welcome, Mage. What potion will you craft today?");
            System.out.print("Start with an ingredient? (yes/no): ");

            userfirstChoice = scanner.nextLine();

             // Create the initial Potion object, either empty or with one ingredient.
            if(userfirstChoice.equals("yes")) {
                
                System.out.println("Enter your first ingredient name and power level (e.g., DragonScale 10): ");

                newIngredient = scanner.next();
                newPower = scanner.nextInt();
                scanner.nextLine();

                Ingredient firstIngredient = new Ingredient(newIngredient, newPower);
                currentPotion = new Potion(firstIngredient);

            }else {
                currentPotion = new Potion();
            }

            // Inner while(true) loop serves as the main menu for adding ingredients.
            while(true) {
                
                System.out.print("Add more ingredients? (single/multiple/mix/done): ");
                
                userChoiceType = scanner.nextLine();

                // The only way to exit this menu loop is by typing "done".
                if(userChoiceType.equals("done")) {
                    break;
                }

                switch (userChoiceType) {

                    case "single":

                        System.out.println("Enter ingredient name and power level: ");

                        newIngredient = scanner.next();
                        newPower = scanner.nextInt();
                        scanner.nextLine();

                        currentPotion.addIngredient(newIngredient, newPower);

                        break;

                    case "multiple":

                        System.out.println("Enter ingredient name, power level, and quantity (e.g., GlimmeringMoss 5 3):");

                        newIngredient = scanner.next();
                        newPower = scanner.nextInt();
                        newQuantity = scanner.nextInt();
                        scanner.nextLine();

                        currentPotion.addIngredient(newIngredient, newPower, newQuantity);

                        break;

                    case "mix":

                        System.out.println("Enter ingredients to mix in (type 'done' to finish): ");

                        LinkedList<Ingredient> mixedIngredients = new LinkedList<>();

                        while(true) {

                            newIngredient = scanner.next();

                            if(newIngredient.equals("done"))
                                break;

                            newPower = scanner.nextInt();
                            scanner.nextLine();

                            mixedIngredients.add(new Ingredient(newIngredient, newPower));

                        }

                        currentPotion.addManyMixed(mixedIngredients);

                        break;
                    
                    default:

                        System.out.println("Invalid choice. Please enter single, multiple, mix, or done.");
                        break;
                }
            }

            // After the user is done, print the final potion details.
            System.out.println("Your Potion is ready!");
            currentPotion.printIngredients();
            System.out.println(currentPotion);

            // Ask the user if they want to run the program again.
            System.out.print("\nWould you like to create another potion? (yes/no): ");
            createAnotherChoice = scanner.nextLine();
            System.out.println();

        } while (createAnotherChoice.equals("yes"));

        System.out.printf("Total potions crafted: %d\n", Potion.getPotionCount());
        scanner.close();
    }
}
