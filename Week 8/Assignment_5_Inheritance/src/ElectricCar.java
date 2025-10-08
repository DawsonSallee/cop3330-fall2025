public class ElectricCar extends Vehicle implements Rechargeable {

    private int batteryPercent;
    
    public ElectricCar(String vehicleID, int maxSpeed, int initialBatteryPercent) {
        
        super(vehicleID, maxSpeed);

        this.batteryPercent = initialBatteryPercent;
    }

    @Override
    public String getEngineType() {
        return "Electric";
    }

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

    @Override
    public String performMaintenance() {

        recharge();

        return "Electric systems checked. Charging initiated.";
    }
}
