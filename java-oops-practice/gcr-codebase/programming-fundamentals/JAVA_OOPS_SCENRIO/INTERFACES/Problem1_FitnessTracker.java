// Problem 1: Fitness Tracker - Multiple Interface Implementation
// Trackable, Reportable, Notifiable interfaces all implemented by FitnessDevice
// Demonstrate that Java cannot do multiple inheritance with classes, but can with interfaces

interface Trackable {
    void logActivity(String activity, int duration);

    default void resetData() {
        System.out.println("[Trackable] Resetting all activity data to default values.");
    }
}

interface Reportable {
    void generateReport();

    default void resetData() {
        System.out.println("[Reportable] Resetting report data.");
    }
}

interface Notifiable {
    void sendAlert(String message);
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
    private String deviceName;
    private String[] activities;
    private int count;

    public FitnessDevice(String deviceName, int capacity) {
        this.deviceName = deviceName;
        this.activities = new String[capacity];
        this.count = 0;
    }

    public void logActivity(String activity, int duration) {
        if (count < activities.length) {
            activities[count] = activity + " for " + duration + " min";
            count++;
            System.out.println("[Logged] " + activity + " for " + duration + " minutes on " + deviceName);
        }
    }

    public void generateReport() {
        System.out.println("\n--- Fitness Report for " + deviceName + " ---");
        if (count == 0) {
            System.out.println("No activities recorded.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println("  " + (i + 1) + ". " + activities[i]);
            }
        }
        System.out.println("Total activities: " + count);
        System.out.println("----------------------------------\n");
    }

    public void sendAlert(String message) {
        System.out.println("[Alert from " + deviceName + "] " + message);
    }

    @Override
    public void resetData() {
        Trackable.super.resetData();
        this.activities = new String[activities.length];
        this.count = 0;
        System.out.println("All data has been reset on " + deviceName);
    }
}

public class Problem1_FitnessTracker {
    public static void main(String[] args) {
        System.out.println("=== Problem 1: Fitness Tracker (Multiple Interfaces) ===\n");

        FitnessDevice fitbit = new FitnessDevice("Fitbit Charge 6", 10);

        fitbit.logActivity("Running", 30);
        fitbit.logActivity("Cycling", 45);
        fitbit.logActivity("Swimming", 25);

        fitbit.generateReport();
        fitbit.sendAlert("Your heart rate is above normal!");

        System.out.println("--- Demonstrating default method override ---");
        fitbit.resetData();
        fitbit.generateReport();

        System.out.println("--- Multiple inheritance with interfaces (classes cannot do this) ---");
        Trackable t = fitbit;
        Reportable r = fitbit;
        Notifiable n = fitbit;
        System.out.println("FitnessDevice IS-A Trackable: " + (fitbit instanceof Trackable));
        System.out.println("FitnessDevice IS-A Reportable: " + (fitbit instanceof Reportable));
        System.out.println("FitnessDevice IS-A Notifiable: " + (fitbit instanceof Notifiable));
    }
}
