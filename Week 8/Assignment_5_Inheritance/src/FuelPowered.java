// Dawson Sallee
// Assignment 5
// COP3330

/**
 * Defines the contract for any vehicle that runs on fuel.
 * Classes implementing this interface must provide methods to check the fuel level
 * and perform a refueling action.
 */
public interface FuelPowered {

    /**
     * Checks the current amount of fuel in the vehicle's tank.
     * @return The fuel level in gallons.
     */
    public double checkFuelLevel();

    /**
     * Simulates refueling the vehicle to its maximum capacity.
     */
    public void refuel();
    
}