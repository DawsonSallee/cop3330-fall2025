// Dawson Sallee
// Assignment 5
// COP3330

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class to manage and simulate the vehicle fleet.
 * It handles user interaction and orchestrates diagnostics and maintenance
 * for a list of generic Vehicle objects, demonstrating polymorphism.
 */
public class FleetManager {
    
    /**
     * Prints a detailed status report for every vehicle in the fleet.
     * @param fleet The list of all vehicles to diagnose.
     */
    public static void runDiagnostics(List<Vehicle> fleet) {
        
        for(int i = 0; i < fleet.size(); i++) {
            System.out.printf("Vehicle ID: %s (%s). Engine: %s. Status: %s\n", 
            fleet.get(i).getVehicleID(), 
            fleet.get(i).getEngineType(), 
            fleet.get(i).getEngineType(), 
            fleet.get(i).getPowerStatus());
        }
    }

    /**
     * Filters the main fleet to identify only vehicles that require service.
     * @param fleet The complete list of all vehicles.
     * @return A new List containing only the vehicles that need maintenance.
     */
    public static List<Vehicle> prioritizeMaintenance(List<Vehicle> fleet) {

        List<Vehicle> urgentFleet = new ArrayList<>();

        for(int i = 0; i < fleet.size(); i++) {
            if(fleet.get(i).needsService()) {
                urgentFleet.add(fleet.get(i));
            }
        }

        return urgentFleet;
    }

    /**
     * Executes the maintenance routine on a given list of vehicles and prints the results.
     * @param urgentFleet The prioritized list of vehicles needing maintenance.
     */
    public static void startMaintenance(List<Vehicle> urgentFleet) {
        for(Vehicle vehicle : urgentFleet) {

            String result = vehicle.performMaintenance();
            
            System.out.printf("%s: %s\n", vehicle.getVehicleID(), result);
        }
    }
        
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Create the master list to hold all vehicles.
        List<Vehicle> fleet = new ArrayList<>();
        List<Vehicle> urgentFleet;

        // Variables to hold user responses.
        String userInputDiagnostics;
        String userInputMaintenance;

        fleet.add(new ElectricCar("E-450", 100, 20));
        fleet.add(new ElectricCar("E-101", 105, 90));
        fleet.add(new DieselTruck("D-900", 110, 5.5));
        fleet.add(new DieselTruck("D-500", 115, 40));

        System.out.println("Welcome to the Logistics Fleet Manager.\n");
        System.out.print("Ready to begin fleet diagnostics? (y/n): ");
        userInputDiagnostics = scanner.nextLine();

        if(userInputDiagnostics.equals("y")) {
            
            // 1. Initial Diagnosis
            System.out.println("\n--- Fleet Diagnosis Report (Initial Status) ---\n");
            runDiagnostics(fleet);

            // 2. Prioritization Scan
            System.out.println("\n--- Prioritization Scan ---");
            urgentFleet = prioritizeMaintenance(fleet);

            
            System.out.printf("The following %d Vehicles require urgent service: \n", urgentFleet.size());

            for(Vehicle vehicle : urgentFleet) {
                System.out.printf("- %s (%s)\n",
                vehicle.getVehicleID(),
                vehicle.getEngineType());
            }

            // 3. Maintenance Action
            if(urgentFleet.size() > 0) {

                System.out.print("\nCritical issues found. Run full maintenance on prioritized vehicles? (y/n): ");
                userInputMaintenance = scanner.nextLine();

                if(userInputMaintenance.equals("y")) {

                    System.out.println("--- Running Urgent Maintenance ---\n");
                    startMaintenance(urgentFleet);
                }
            }
        }

        // 4. Final Report
        System.out.println("\n--- Fleet Diagnosis Report (Post-Maintenance Status) ---\n");
        runDiagnostics(fleet);

        System.out.println("\nSimulation complete. Have a productive day!\n");
        scanner.close();
    }
}
