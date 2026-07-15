// Additional 2: Smart Healthcare Monitoring System

interface HeartRateMonitor {
    default void displayHealthTips() {
        System.out.println("[HeartRateMonitor] Normal resting HR: 60-100 bpm. Stay hydrated.");
    }
}

interface TemperatureMonitor {
    default void displayHealthTips() {
        System.out.println("[TemperatureMonitor] Normal body temp: 36.5-37.5°C. Rest if feverish.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId != null && patientId.matches("PAT\\d{4}");
    }
}

class HealthData {
    String name;
    String id;
    int heartRate;
    double temperature;

    HealthData(String name, String id, int hr, double temp) {
        this.name = name;
        this.id = id;
        this.heartRate = hr;
        this.temperature = temp;
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
    private HealthData[] patients;

    public HealthMonitoringSystem(HealthData[] patients) {
        this.patients = patients;
    }

    @Override
    public void displayHealthTips() {
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
        System.out.println("[HealthSystem] Full health advisory active.");
    }

    public void generateReport() {
        System.out.println("\n========== FINAL HEALTH REPORT ==========");
        System.out.println("=========================================\n");

        for (int i = 0; i < patients.length; i++) {
            HealthData p = patients[i];
            System.out.println("Patient " + (i + 1) + ": " + p.name);
            System.out.println("  ID: " + p.id);

            boolean validId = TemperatureMonitor.isPatientIdValid(p.id);
            System.out.println("  ID Valid: " + (validId ? "YES" : "NO"));

            if (!validId) {
                System.out.println("  -> STATUS: INVALID ID - Cannot process");
                continue;
            }

            System.out.println("  Heart Rate: " + p.heartRate + " bpm");
            System.out.println("  Temperature: " + p.temperature + "°C");

            boolean hrNormal = p.heartRate >= 60 && p.heartRate <= 100;
            boolean tempNormal = p.temperature >= 36.5 && p.temperature <= 37.5;

            if (hrNormal && tempNormal) {
                System.out.println("  -> STATUS: HEALTHY");
            } else {
                System.out.print("  -> STATUS: ");
                if (!hrNormal) System.out.print("ABNORMAL HEART RATE. ");
                if (!tempNormal) System.out.print("ABNORMAL TEMPERATURE. ");
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("=========================================\n");
    }
}

public class Additional2_HealthMonitoring {
    public static void main(String[] args) {
        System.out.println("=== Additional 2: Smart Healthcare Monitoring ===\n");

        HealthData[] patients = {
            new HealthData("John Doe", "PAT1234", 72, 37.0),
            new HealthData("Jane Smith", "INVALID", 85, 38.5),
            new HealthData("Bob Wilson", "PAT5678", 110, 36.8),
            new HealthData("Alice Brown", "PAT9012", 95, 39.2)
        };

        HealthMonitoringSystem system = new HealthMonitoringSystem(patients);
        system.displayHealthTips();
        system.generateReport();
    }
}
