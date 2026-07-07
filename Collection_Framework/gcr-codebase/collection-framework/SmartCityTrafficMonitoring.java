import java.util.*;

public class SmartCityTrafficMonitoring {

    HashMap<String, Integer> traffic = new HashMap<>();

    // Add or Update Vehicle Count
    public void updateTraffic(String road, int vehicles) {
        traffic.put(road, traffic.getOrDefault(road, 0) + vehicles);
        System.out.println("Updated " + road + " with " + vehicles + " vehicles.");
    }

    // Display Roads in Sorted Order
    public void displayTraffic() {

        TreeMap<String, Integer> sortedTraffic = new TreeMap<>(traffic);

        System.out.println("\nTraffic Report:");

        for (Map.Entry<String, Integer> entry : sortedTraffic.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " vehicles");
        }
    }

    // Find Busiest Road
    public void busiestRoad() {

        String road = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : traffic.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                road = entry.getKey();
            }
        }

        System.out.println("\nBusiest Road: " + road);
        System.out.println("Vehicle Count: " + max);
    }

    // Total Roads
    public void totalRoads() {
        System.out.println("Total Roads Monitored: " + traffic.size());
    }

    public static void main(String[] args) {

        SmartCityTrafficMonitoring city = new SmartCityTrafficMonitoring();

        city.updateTraffic("MG Road", 250);
        city.updateTraffic("NH-44", 500);
        city.updateTraffic("Ring Road", 350);
        city.updateTraffic("MG Road", 100); // Update existing road

        city.displayTraffic();

        city.busiestRoad();

        city.totalRoads();
    }
}