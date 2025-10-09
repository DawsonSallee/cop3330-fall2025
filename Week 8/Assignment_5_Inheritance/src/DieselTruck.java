// Dawson Sallee
// Assignment 5
// COP3330

/**
 * Represents a diesel truck in the fleet.
 * It inherits from Vehicle and implements the FuelPowered interface.
 */
public class DieselTruck extends Vehicle implements FuelPowered {
    
    private double fuelGallons = 0;

    /**
     * Constructs a new DieselTruck.
     * @param vehicleID The unique ID for the truck.
     * @param maxSpeed The maximum speed of the truck.
     * @param intfuelGallons The starting fuel level in gallons.
     */
    public DieselTruck(String vehicleID, int maxSpeed, double intfuelGallons) {
        
        super(vehicleID, maxSpeed);
        this.fuelGallons = intfuelGallons;
    }

    @Override
    public double checkFuelLevel() {
        return this.fuelGallons;
    }

    /**
     * A diesel truck needs service if its fuel level is below 10.0 gallons.
     * @return true if fuel is less than 10, otherwise false.
     */
    @Override
    public boolean needsService() {
        return checkFuelLevel() < 10;
    }

    /**
     * Generates a status report for the truck's fuel level.
     * It calls checkFuelLevel() as required by the assignment and adds a
     * "CRITICAL" warning if service is needed.
     * @return A formatted string with the current fuel status.
     */
    @Override
    public String getPowerStatus() {

        String status = String.format("Fuel: %.2f gal", checkFuelLevel());

        if(needsService()) {
            status += " (CRITICAL)";
        }

        return status;
    }
    
    @Override
    public void refuel() {
        this.fuelGallons = 50;
    }

    /**
     * Performs maintenance on the diesel truck by filling its fuel tank.
     * It calls the refuel() method as required by the assignment.
     * @return A message indicating the maintenance action taken.
     */
    @Override
    public String performMaintenance() {
        refuel();
        return "Fluid levels good. Refueling truck.";
    }

    @Override
    public String getEngineType() {
        return "Diesel";
    }
}
