package Models;

public class Truck extends Vehicle {
    private double loadCapacity; // in tons

    public Truck(String vehicleId, String model, double baseRentalRate, double loadCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days; // Simple calculation
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable(); // Use inherited method
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        if (loadCapacity <= 0) {
            throw new IllegalArgumentException("Load capacity must be positive.");
        }
        this.loadCapacity = loadCapacity;
    }

   @Override
   public String toString() {
       return "Truck{" +
               "vehicleId='" + getVehicleId() + '\'' +
               ", model='" + getModel() + '\'' +
               ", baseRentalRate=" + getBaseRentalRate() +
               ", isAvailable=" + isAvailable() +
               ", loadCapacity=" + loadCapacity +
               '}';
   }
}
