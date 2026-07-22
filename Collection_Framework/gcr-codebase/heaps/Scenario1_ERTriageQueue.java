import java.util.PriorityQueue;

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String toString() {
        return name + "(severity=" + severity + ")";
    }
}

public class Scenario1_ERTriageQueue {

    private final PriorityQueue<Patient> triageQueue;

    public Scenario1_ERTriageQueue() {
        triageQueue = new PriorityQueue<>((a, b) -> b.severity - a.severity);
    }

    public void addPatient(Patient p) {
        triageQueue.offer(p);
    }

    public Patient treatNext() {
        return triageQueue.poll();
    }

    public Patient peekNext() {
        return triageQueue.peek();
    }

    public boolean hasPatients() {
        return !triageQueue.isEmpty();
    }

    public static void main(String[] args) {
        Scenario1_ERTriageQueue er = new Scenario1_ERTriageQueue();

        er.addPatient(new Patient("Alice", 3));
        er.addPatient(new Patient("Bob", 8));
        er.addPatient(new Patient("Charlie", 1));
        er.addPatient(new Patient("Diana", 5));

        System.out.println("Next to treat: " + er.peekNext());

        while (er.hasPatients()) {
            System.out.println("Treating: " + er.treatNext());
        }
    }
}
