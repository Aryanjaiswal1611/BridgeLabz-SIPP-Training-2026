import java.util.ArrayList;

public class SmartParkingSlotManager {

    ArrayList<String> vehicles = new ArrayList<>();

    // Add Vehicle
    public void addVehicle(String regNo) {
        if (vehicles.contains(regNo)) {
            System.out.println("Vehicle is already parked.");
        } else {
            vehicles.add(regNo);
            System.out.println("Vehicle " + regNo + " entered the parking area.");
        }
    }

    // Remove Vehicle
    public void removeVehicle(String regNo) {
        if (vehicles.remove(regNo)) {
            System.out.println("Vehicle " + regNo + " exited the parking area.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    // Search Vehicle
    public void searchVehicle(String regNo) {
        if (vehicles.contains(regNo)) {
            System.out.println("Vehicle " + regNo + " is currently parked.");
        } else {
            System.out.println("Vehicle " + regNo + " is not parked.");
        }
    }

    // Display All Vehicles
    public void displayVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("Parking area is empty.");
        } else {
            System.out.println("\nVehicles Currently Parked:");
            for (String vehicle : vehicles) {
                System.out.println(vehicle);
            }
            System.out.println("Total Occupied Parking Slots: " + vehicles.size());
        }
    }

    public static void main(String[] args) {

        SmartParkingSlotManager parking = new SmartParkingSlotManager();

        parking.addVehicle("UP85AB1234");
        parking.addVehicle("DL01CD5678");
        parking.addVehicle("HR26EF9012");

        parking.searchVehicle("DL01CD5678");

        parking.removeVehicle("DL01CD5678");

        parking.searchVehicle("DL01CD5678");

        parking.displayVehicles();
    }
}