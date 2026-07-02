import java.util.*;

class Astronaut {
    int astronautId;
    String name;
    String specialization;

    Astronaut(int astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "ID: " + astronautId +
               ", Name: " + name +
               ", Specialization: " + specialization;
    }
}

public class SpaceMissionCrewManagementSystem {

    HashMap<String, List<Astronaut>> missions = new HashMap<>();
    HashMap<String, HashSet<String>> assigned = new HashMap<>();

    // Add Mission
    public void addMission(String missionName) {
        missions.putIfAbsent(missionName, new ArrayList<>());
        assigned.putIfAbsent(missionName, new HashSet<>());
        System.out.println("Mission " + missionName + " added.");
    }

    // Assign Astronaut
    public void assignAstronaut(String missionName, Astronaut astronaut) {

        if (!missions.containsKey(missionName)) {
            System.out.println("Mission not found.");
            return;
        }

        if (assigned.get(missionName).contains(String.valueOf(astronaut.astronautId))) {
            System.out.println("Astronaut already assigned to " + missionName);
        } else {
            missions.get(missionName).add(astronaut);
            assigned.get(missionName).add(String.valueOf(astronaut.astronautId));
            System.out.println("Astronaut assigned successfully.");
        }
    }

    // Display Missions
    public void displayMissions() {

        for (String mission : missions.keySet()) {

            System.out.println("\nMission: " + mission);

            List<Astronaut> crew = missions.get(mission);

            for (Astronaut a : crew) {
                System.out.println(a);
            }

            System.out.println("Total Astronauts: " + crew.size());
        }
    }

    public static void main(String[] args) {

        SpaceMissionCrewManagementSystem system =
                new SpaceMissionCrewManagementSystem();

        system.addMission("Chandrayaan");
        system.addMission("Mars Mission");

        Astronaut a1 = new Astronaut(101, "Rahul", "Pilot");
        Astronaut a2 = new Astronaut(102, "Aman", "Scientist");
        Astronaut a3 = new Astronaut(103, "Priya", "Engineer");

        system.assignAstronaut("Chandrayaan", a1);
        system.assignAstronaut("Chandrayaan", a2);
        system.assignAstronaut("Mars Mission", a3);

        // Duplicate Assignment
        system.assignAstronaut("Chandrayaan", a1);

        system.displayMissions();
    }
}