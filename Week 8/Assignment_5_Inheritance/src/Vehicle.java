public abstract class Vehicle {

    private String vehicleID;
    private int maxSpeed;

    public Vehicle(String vehicleID, int maxSpeed) {

        this.vehicleID = vehicleID;
        this.maxSpeed = maxSpeed;

    }

    public abstract String getEngineType();

    public abstract boolean needsService();

    public String getPowerStatus() {

        return "Power status unknown.";
    }

    public String performMaintenance() {

        return "Standard checkup complete.";
    }

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