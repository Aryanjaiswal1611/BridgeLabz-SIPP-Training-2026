import java.util.*;

class SmartParkingSlotManager {
    private ArrayList<String> parkedVehicles;
    private int capacity;

    public SmartParkingSlotManager(int capacity) {
        this.parkedVehicles = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean enterParking(String registrationNumber) {
        if (parkedVehicles.size() >= capacity) {
            System.out.println("Parking full! Cannot add vehicle: " + registrationNumber);
            return false;
        }
        if (parkedVehicles.contains(registrationNumber)) {
            System.out.println("Vehicle already parked: " + registrationNumber);
            return false;
        }
        parkedVehicles.add(registrationNumber);
        System.out.println("Vehicle entered: " + registrationNumber);
        return true;
    }

    public boolean exitParking(String registrationNumber) {
        if (parkedVehicles.remove(registrationNumber)) {
            System.out.println("Vehicle exited: " + registrationNumber);
            return true;
        }
        System.out.println("Vehicle not found: " + registrationNumber);
        return false;
    }

    public boolean searchVehicle(String registrationNumber) {
        boolean found = parkedVehicles.contains(registrationNumber);
        System.out.println(registrationNumber + " is " + (found ? "" : "not ") + "currently parked.");
        return found;
    }

    public void displayAll() {
        System.out.println("\n--- Parked Vehicles ---");
        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles parked.");
        } else {
            for (int i = 0; i < parkedVehicles.size(); i++) {
                System.out.println("Slot " + (i + 1) + ": " + parkedVehicles.get(i));
            }
        }
        System.out.println("Total occupied slots: " + parkedVehicles.size() + " / " + capacity);
    }

    public static void main(String[] args) {
        SmartParkingSlotManager parking = new SmartParkingSlotManager(5);

        parking.enterParking("MH-01-AB-1234");
        parking.enterParking("MH-02-CD-5678");
        parking.enterParking("MH-03-EF-9012");
        parking.enterParking("MH-01-AB-1234"); // duplicate
        parking.enterParking("MH-04-GH-3456");
        parking.enterParking("MH-05-IJ-7890");
        parking.enterParking("MH-06-KL-1111"); // full

        parking.searchVehicle("MH-02-CD-5678");
        parking.searchVehicle("MH-99-XX-0000");

        parking.exitParking("MH-02-CD-5678");
        parking.exitParking("MH-99-XX-0000"); // not found

        parking.displayAll();
    }
}
