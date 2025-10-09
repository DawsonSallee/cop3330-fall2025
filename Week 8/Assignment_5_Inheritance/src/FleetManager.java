import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FleetManager {
    
    public static void runDiagnostics(List<Vehicle> fleet) {
        
        for(int i = 0; i < fleet.size(); i++) {
            System.out.printf("Vehicle ID: %s (%s). Engine: %s. Status: %s\n", 
            fleet.get(i).getVehicleID(), 
            fleet.get(i).getEngineType(), 
            fleet.get(i).getEngineType(), 
            fleet.get(i).getPowerStatus());
        }
    }

    public static List<Vehicle> prioritizeMaintenance(List<Vehicle> fleet) {

        List<Vehicle> urgentFleet = new ArrayList<>();

        for(int i = 0; i < fleet.size(); i++) {
            if(fleet.get(i).needsService()) {
                urgentFleet.add(fleet.get(i));
            }
        }

        return urgentFleet;
    }

    public static void startMaintenance(List<Vehicle> urgentFleet) {
        for(Vehicle vehicle : urgentFleet) {

            String result = vehicle.performMaintenance();
            
            System.out.printf("%s: %s\n", vehicle.getVehicleID(), result);
        }
    }
        
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> fleet = new ArrayList<>();
        List<Vehicle> urgentFleet;

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
            
            System.out.println("\n--- Fleet Diagnosis Report (Initial Status) ---\n");
            runDiagnostics(fleet);

            System.out.println("\n--- Prioritization Scan ---");

            urgentFleet = prioritizeMaintenance(fleet);

            
            System.out.printf("The following %d Vehicles require urgent service: \n", urgentFleet.size());

            for(Vehicle vehicle : urgentFleet) {
                System.out.printf("- %s (%s)\n",
                vehicle.getVehicleID(),
                vehicle.getEngineType());
            }

            if(urgentFleet.size() > 0) {

                System.out.print("\nCritical issues found. Run full maintenance on prioritized vehicles? (y/n): ");
                userInputMaintenance = scanner.nextLine();

                if(userInputMaintenance.equals("y")) {

                    System.out.println("--- Running Urgent Maintenance ---\n");
                    startMaintenance(urgentFleet);
                }
            }
        }
        
        System.out.println("\n--- Fleet Diagnosis Report (Post-Maintenance Status) ---\n");
        runDiagnostics(fleet);

        System.out.println("\nSimulation complete. Have a productive day!\n");
        scanner.close();
    }
}
