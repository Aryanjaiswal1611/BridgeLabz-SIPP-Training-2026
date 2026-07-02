import java.util.*;

class EventEntryVerificationSystem {
    private HashSet<String> participants;

    public EventEntryVerificationSystem() {
        participants = new HashSet<>();
    }

    public boolean registerParticipant(String email) {
        if (participants.contains(email)) {
            System.out.println("Duplicate registration rejected: " + email);
            return false;
        }
        participants.add(email);
        System.out.println("Participant registered: " + email);
        return true;
    }

    public void displayParticipants() {
        System.out.println("\n--- Registered Participants ---");
        if (participants.isEmpty()) {
            System.out.println("No participants registered.");
        } else {
            for (String email : participants) {
                System.out.println(email);
            }
        }
        System.out.println("Total attendees: " + participants.size());
    }

    public static void main(String[] args) {
        EventEntryVerificationSystem event = new EventEntryVerificationSystem();

        event.registerParticipant("alice@techconf.com");
        event.registerParticipant("bob@techconf.com");
        event.registerParticipant("charlie@techconf.com");
        event.registerParticipant("alice@techconf.com"); // duplicate
        event.registerParticipant("diana@techconf.com");

        event.displayParticipants();
    }
}
