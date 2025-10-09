// Dawson Sallee
// Assignment 5
// COP3330

/**
 * Represents an electric car in the fleet.
 * It inherits from Vehicle and implements the Rechargeable interface.
 */
public class ElectricCar extends Vehicle implements Rechargeable {

    private int batteryPercent;
    
    /**
     * Constructs a new ElectricCar.
     * @param vehicleID The unique ID for the car.
     * @param maxSpeed The maximum speed of the car.
     * @param initialBatteryPercent The starting battery percentage.
     */
    public ElectricCar(String vehicleID, int maxSpeed, int initialBatteryPercent) {
        
        super(vehicleID, maxSpeed);

        this.batteryPercent = initialBatteryPercent;
    }

    @Override
    public String getEngineType() {
        return "Electric";
    }

    /**
     * An electric car needs service if its battery is below 25%.
     * @return true if battery is less than 25, otherwise false.
     */
    @Override
    public boolean needsService() {
        if(batteryPercent < 25){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int getBatteryLevel() {
        return this.batteryPercent;
    }

    /**
     * Generates a status report for the car's battery level.
     * It calls getBatteryLevel() as required by the assignment and adds a
     * "CRITICAL" warning if service is needed.
     * @return A formatted string with the current battery status.
     */
    @Override
    public String getPowerStatus() {
        String status = String.format("Battery: %d%%", getBatteryLevel());

        if(needsService()){
            status += " (CRITICAL)";
        }
        return status;
    }

    @Override
    public void recharge() {
        this.batteryPercent = 100;
    }

    /**
     * Performs maintenance on the electric car by fully charging its battery.
     * It calls the recharge() method as required by the assignment.
     * @return A message indicating the maintenance action taken.
     */
    @Override
    public String performMaintenance() {

        recharge();

        return "Electric systems checked. Charging initiated.";
    }
}
