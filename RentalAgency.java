package Models;

import java.util.ArrayList;
import java.util.List;
import Exceptions.VehicleUnavailableException;
import Exceptions.InvalidRentalException;

public class RentalAgency {
    private List<Vehicle> vehicles;

    public RentalAgency() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailableForRental()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    // Keep this method for renting a vehicle with days and exception handling
   
    public void rentVehicle(Customer customer, Vehicle vehicle, int days) throws VehicleUnavailableException, InvalidRentalException {
        if (!vehicle.isAvailableForRental()) {
            throw new VehicleUnavailableException(vehicle.getModel() + " is not available for rental.");
        }
        
        if (days <= 0) {
            throw new InvalidRentalException("Rental days must be greater than zero.");
        }


        customer.rentVehicle(vehicle);
        double rentalCost = vehicle.calculateRentalCost(days);
        customer.addloyaltyPoints((int) rentalCost / 10); // Example: 1 point for every $10 spent
        System.out.println(customer.getName() + " has rented " + vehicle.getModel());
    }

    // Remove this duplicate method
    // public void rentVehicle(Customer customer, Vehicle vehicle) {
    //     if (vehicle.isAvailableForRental()) {
    //         customer.rentVehicle(vehicle);
    //         System.out.println(customer.getName() + " has rented " + vehicle.getModel());
    //     } else {
    //         System.out.println("Sorry, " + vehicle.getModel() + " is not available for rental.");
    //     }
    // }

    public void returnVehicle(Customer customer, Vehicle vehicle) {
        customer.returnVehicle(vehicle);
        System.out.println(customer.getName() + " has returned " + vehicle.getModel());
    }

    @Override
    public String toString() {
        return "RentalAgency{" +
                "vehicles=" + vehicles +
                '}';
    }
}
