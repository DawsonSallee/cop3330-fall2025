// Dawson Sallee
// Assignment 5
// COP3330

/**
 * An abstract base class representing a generic vehicle in the fleet.
 * It defines common properties like vehicle ID and max speed, as well as
 * abstract methods that all specific vehicle types must implement.
 */
public abstract class Vehicle {

    private String vehicleID; // The unique identifier for the vehicle.
    private int maxSpeed; // The maximum speed of the vehicle.

    /**
     * Constructs a new Vehicle with a specific ID and maximum speed.
     * @param vehicleID The unique identifier for the vehicle.
     * @param maxSpeed The maximum speed of the vehicle.
     */
    public Vehicle(String vehicleID, int maxSpeed) {

        this.vehicleID = vehicleID;
        this.maxSpeed = maxSpeed;

    }


    // --- Abstract Methods (Must be implemented by subclasses) ---

    /**
     * Gets the type of engine for the vehicle (e.g., "Electric", "Diesel").
     * @return A string representing the engine type.
     */
    public abstract String getEngineType();

    /**
     * Determines if the vehicle requires maintenance based on its specific criteria
     * (e.g., low fuel, low battery).
     * @return true if service is needed, false otherwise.
     */
    public abstract boolean needsService();

    
    // --- Concrete Methods (Provide default behavior) ---

    /**
     * Provides a default power status message. Subclasses should override this
     * to give a more specific status.
     * @return A generic status string.
     */
    public String getPowerStatus() {

        return "Power status unknown.";
    }

    /**
     * Provides a default maintenance action message. Subclasses should override this
     * to perform specific maintenance tasks.
     * @return A generic maintenance completion message.
     */
    public String performMaintenance() {

        return "Standard checkup complete.";
    }

    
    // --- Getters and Setters ---

    public String getVehicleID() {
        return this.vehicleID;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}