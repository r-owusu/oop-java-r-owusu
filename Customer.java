package Models;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String contactInfo;
    private List<Vehicle> rentedVehicles;
    private int  loyaltyPoints;

    public Customer(String customerId, String name, String contactInfo) {
        this.customerId = customerId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.loyaltyPoints = 0;
        this.rentedVehicles = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<Vehicle> getRentedVehicles() {
        return rentedVehicles;
    }

    public void rentVehicle(Vehicle vehicle) {
        rentedVehicles.add(vehicle);
        vehicle.setAvailable(false); // Mark vehicle as not available
    }

    public void returnVehicle(Vehicle vehicle) {
        rentedVehicles.remove(vehicle);
        vehicle.setAvailable(true); // Mark vehicle as available
    }

   public void addloyaltyPoints(int points){
	this.loyaltyPoints += points;
}
   public int getloyaltyPoints() {
	return loyaltyPoints;
}
  public void redeemLoyaltyPoints(int points) {
	if (points <= loyaltyPoints) {
		loyaltyPoints -=points;
	}else {
		throw new
IllegalArgumentException("Not enough loyalty points.");
		}
	}


    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", rentedVehicles=" + rentedVehicles +
		", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
