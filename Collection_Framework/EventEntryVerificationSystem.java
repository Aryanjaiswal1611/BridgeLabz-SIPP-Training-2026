import java.util.HashSet;

public class EventEntryVerificationSystem {

    HashSet<String> participants = new HashSet<>();

    // Register Participant
    public void registerParticipant(String email) {
        if (participants.add(email)) {
            System.out.println(email + " registered successfully.");
        } else {
            System.out.println("Duplicate registration! " + email + " is already registered.");
        }
    }

    // Display Participants
    public void displayParticipants() {
        System.out.println("\nRegistered Participants:");
        for (String email : participants) {
            System.out.println(email);
        }
        System.out.println("Total Eligible Attendees: " + participants.size());
    }

    public static void main(String[] args) {

        EventEntryVerificationSystem event = new EventEntryVerificationSystem();

        event.registerParticipant("john@gmail.com");
        event.registerParticipant("alice@gmail.com");
        event.registerParticipant("bob@gmail.com");

        // Duplicate Registration
        event.registerParticipant("john@gmail.com");

        event.displayParticipants();
    }
}