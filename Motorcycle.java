package Models;

public class Motorcycle extends Vehicle {
    private double engineSize; // in liters

    public Motorcycle(String vehicleId, String model, double baseRentalRate, double engineSize) {
        super(vehicleId, model, baseRentalRate);
        this.engineSize = engineSize;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days; // Simple calculation
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable(); // Use inherited method
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        if (engineSize <= 0) {
            throw new IllegalArgumentException("Engine size must be positive.");
        }
        this.engineSize = engineSize;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "vehicleId='" + getVehicleId() + '\'' +
                ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() +
                ", isAvailable=" + isAvailable() +
                ", engineSize=" + engineSize +
                '}';
    }
}

