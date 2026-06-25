// Additional 1: Airport Security Management System

interface LuggageScanner {
    default void displaySecurityGuidelines() {
        System.out.println("[LuggageScanner] All bags must be X-ray scanned. No liquids > 100ml.");
    }
}

interface PassportVerifier {
    default void displaySecurityGuidelines() {
        System.out.println("[PassportVerifier] Passport must be valid for 6+ months from travel date.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.matches("[A-Z]{2}[0-9]{7}");
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    private String[] passengerNames;
    private String[] passportNumbers;
    private boolean[] luggageCleared;

    public AirportSecuritySystem(String[] names, String[] passports, boolean[] luggage) {
        this.passengerNames = names;
        this.passportNumbers = passports;
        this.luggageCleared = luggage;
    }

    @Override
    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
        System.out.println("[AirportSecurity] All checks enforced before boarding.");
    }

    public void processPassengers() {
        System.out.println("\n--- Boarding Clearance Report ---");
        for (int i = 0; i < passengerNames.length; i++) {
            System.out.println("\nPassenger: " + passengerNames[i]);
            System.out.println("  Passport: " + passportNumbers[i]);

            boolean passportValid = PassportVerifier.isPassportNumberValid(passportNumbers[i]);
            boolean luggageOK = luggageCleared[i];

            if (passportValid && luggageOK) {
                System.out.println("  -> CLEARED TO BOARD");
            } else {
                System.out.print("  -> DENIED: ");
                if (!passportValid) System.out.print("Invalid passport. ");
                if (!luggageOK) System.out.print("Luggage not cleared. ");
                System.out.println();
            }
        }
    }
}

public class Additional1_AirportSecurity {
    public static void main(String[] args) {
        System.out.println("=== Additional 1: Airport Security Management ===\n");

        String[] names = { "Alice Johnson", "Bob Smith", "Charlie Brown", "Diana Prince" };
        String[] passports = { "AB1234567", "INVALID99", "CD9876543", "12345" };
        boolean[] luggage = { true, true, false, true };

        AirportSecuritySystem airport = new AirportSecuritySystem(names, passports, luggage);
        airport.displaySecurityGuidelines();
        airport.processPassengers();
    }
}
