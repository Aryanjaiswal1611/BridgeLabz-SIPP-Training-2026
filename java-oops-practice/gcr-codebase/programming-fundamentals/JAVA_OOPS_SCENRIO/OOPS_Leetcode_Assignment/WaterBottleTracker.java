class WaterBottle {

    String ownerName;
    int dailyTarget;

    public WaterBottle(String ownerName, int dailyTarget) {
        this.ownerName = ownerName;
        this.dailyTarget = dailyTarget;
    }

    public void displayBottleInfo() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Target: " + dailyTarget + " ml");
        System.out.println();
    }
}

public class WaterBottleTracker {

    public static void main(String[] args) {

        WaterBottle b1 = new WaterBottle("Yash", 3000);
        WaterBottle b2 = new WaterBottle("Rahul", 2500);

        b1.displayBottleInfo();
        b2.displayBottleInfo();
    }
}