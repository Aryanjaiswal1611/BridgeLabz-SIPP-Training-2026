class Vehicle {

    String vehicleNumber;
    String ownerName;
    String vehicleType;

    public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void display() {
        System.out.println(vehicleNumber + " - " + ownerName);
    }

    public static void displayCars(Vehicle[] vehicles) {
        System.out.println("\nCars:");
        for (Vehicle v : vehicles) {
            if (v != null && v.vehicleType.equalsIgnoreCase("Car")) {
                v.display();
            }
        }
    }

    public static void displayBikes(Vehicle[] vehicles) {
        System.out.println("\nBikes:");
        for (Vehicle v : vehicles) {
            if (v != null && v.vehicleType.equalsIgnoreCase("Bike")) {
                v.display();
            }
        }
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[10];

        vehicles[0] = new Vehicle("UP81A1", "Yash", "Car");
        vehicles[1] = new Vehicle("UP81A2", "Amit", "Bike");
        vehicles[2] = new Vehicle("UP81A3", "Rahul", "Car");
        vehicles[3] = new Vehicle("UP81A4", "Ravi", "Bike");
        vehicles[4] = new Vehicle("UP81A5", "Karan", "Car");
        vehicles[5] = new Vehicle("UP81A6", "Ankit", "Bike");
        vehicles[6] = new Vehicle("UP81A7", "Deepak", "Car");
        vehicles[7] = new Vehicle("UP81A8", "Sohan", "Bike");
        vehicles[8] = new Vehicle("UP81A9", "Mohan", "Car");
        vehicles[9] = new Vehicle("UP81A10", "Rohan", "Bike");

        displayCars(vehicles);
        displayBikes(vehicles);
    }
}