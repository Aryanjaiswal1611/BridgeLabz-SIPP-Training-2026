class Drone {
    private String droneId;
    private int batteryPercentage;

    static String companyName = "SkyDeliver";

    public Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    public void startDelivery() {
        if (batteryPercentage > 20) {
            System.out.println(droneId + " started delivery.");
        } else {
            System.out.println(droneId + " low battery.");
        }
    }

    public void displayStatus() {
        System.out.println("Company: " + companyName);
        System.out.println("Drone ID: " + droneId);
        System.out.println("Battery: " + batteryPercentage + "%");
    }

    public static void main(String[] args) {

        Drone d1 = new Drone("D101", 90);
        Drone d2 = new Drone("D102", 50);
        Drone d3 = new Drone("D103", 15);

        d1.startDelivery();
        d2.startDelivery();
        d3.startDelivery();

        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();
    }
}