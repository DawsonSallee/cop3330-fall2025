public class DieselTruck extends Vehicle implements FuelPowered {
    
    private double fuelGallons = 0;

    public DieselTruck(String vehicleID, int maxSpeed, double intfuelGallons) {
        
        super(vehicleID, maxSpeed);
        this.fuelGallons = intfuelGallons;
    }

    @Override
    public double checkFuelLevel() {
        return this.fuelGallons;
    }

    @Override
    public boolean needsService() {
        return checkFuelLevel() < 10;
    }

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
