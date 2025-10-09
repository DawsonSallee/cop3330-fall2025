// Dawson Sallee
// Assignment 5
// COP3330

/**
 * Defines the contract for any vehicle that can be recharged.
 * Classes implementing this interface must provide methods to get the battery level
 * and perform a recharge action.
 */
public interface Rechargeable {

    /**
     * Retrieves the current battery level of the vehicle.
     * @return The battery percentage, typically from 0 to 100.
     */
    public int getBatteryLevel();

    /**
     * Simulates recharging the vehicle's battery to its maximum capacity (100%).
     */
    public void recharge();
    
}