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

            System.out.printf("%d. %s (Power: %d)\n", i, this.ingredients.get(i).getName(), this.ingredients.get(i).getPower());
        }

    }

    @Override
    public String toString() {

        int ingredientCount = this.ingredients.size();

        double value = this.calculateValue();
        
        return String.format("This potion contains %d ingredients and is worth $%.2f.", ingredientCount, value);
    }

    public static int getPotionCount() {
        return potionCounter;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userChoice = "no";
        String userChoiceType;

        Potion currentPotion;
        String newIngredient;
        int newPower = 0;
        int newQuantity = 0;

        System.out.println("Welcome, Mage. What potion will you craft today?");
        System.out.print("Start with an ingredient? (yes/no): ");

        userChoice = scanner.nextLine();
        do {
            if(userChoice.equals("yes")) {
                
                System.out.println("Enter your first ingredient name and power level (e.g., DragonScale 10): ");

                newIngredient = scanner.next();
                newPower = scanner.nextInt();
                scanner.nextLine();

                Ingredient firstIngredient = new Ingredient(newIngredient, newPower);
                currentPotion = new Potion(firstIngredient);

            }else {

                currentPotion = new Potion();

            }

            while(userChoice.equals("yes")) {
                
                System.out.print("Add more ingredients? (single/multiple/mix/done): ");
                
                userChoiceType = scanner.nextLine();

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

                        while(true) {

                            newIngredient = scanner.next();

                            if(newIngredient.equals("done"))
                                break;

                            newPower = scanner.nextInt();
                            scanner.nextLine();

                            currentPotion.addIngredient(newIngredient, newPower);
                        }

                        break;

                    case "done":

                        userChoice = "no";
                        break;
                    
                    default:
                        break;
                }
            }

            System.out.println("Your Potion is ready!");

            currentPotion.printIngredients();

            System.out.println(currentPotion);

            System.out.print("\nWould you like to create another potion? (yes/no): ");
            userChoice = scanner.next();
            System.out.println();

        scanner.close();

        } while (userChoice.equals("yes"));
    }
}
