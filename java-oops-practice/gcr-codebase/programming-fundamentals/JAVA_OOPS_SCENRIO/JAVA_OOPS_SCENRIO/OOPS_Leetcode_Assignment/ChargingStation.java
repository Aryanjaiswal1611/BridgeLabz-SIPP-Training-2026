class ChargingStation {

    // Static Variables
    static int totalStations = 0;
    static double electricityRate = 8.5;

    // Instance Variables
    private int stationId;
    private double unitsConsumed;

    // Constructor
    public ChargingStation(int stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    // Calculate Bill
    public double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    // Display Details
    public void displayStationDetails() {
        System.out.println("Station ID : " + stationId);
        System.out.println("Units Consumed : " + unitsConsumed);
        System.out.println("Electricity Rate : ₹" + electricityRate);
        System.out.println("Bill : ₹" + calculateBill());
        System.out.println();
    }

    public static void main(String[] args) {

        ChargingStation s1 = new ChargingStation(101, 120);
        ChargingStation s2 = new ChargingStation(102, 150);
        ChargingStation s3 = new ChargingStation(103, 200);
        ChargingStation s4 = new ChargingStation(104, 180);
        ChargingStation s5 = new ChargingStation(105, 250);

        System.out.println("----- Initial Bills -----");

        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        System.out.println("Total Stations = " + totalStations);

        // Change electricity rate
        electricityRate = 10.0;

        System.out.println("\n----- After Rate Change -----");

        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();
    }
}