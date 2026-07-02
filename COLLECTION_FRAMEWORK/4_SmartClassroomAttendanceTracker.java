import java.util.*;

class SmartClassroomAttendanceTracker {
    private HashMap<String, ArrayList<String>> attendance;

    public SmartClassroomAttendanceTracker() {
        attendance = new HashMap<>();
    }

    public boolean markAttendance(String subject, String studentName) {
        ArrayList<String> students = attendance.get(subject);
        if (students == null) {
            students = new ArrayList<>();
            attendance.put(subject, students);
        }
        if (students.contains(studentName)) {
            System.out.println("Duplicate attendance rejected: " + studentName + " in " + subject);
            return false;
        }
        students.add(studentName);
        System.out.println("Attendance marked: " + studentName + " in " + subject);
        return true;
    }

    public void displayAttendance() {
        System.out.println("\n--- Attendance Records ---");
        if (attendance.isEmpty()) {
            System.out.println("No attendance records.");
            return;
        }
        for (Map.Entry<String, ArrayList<String>> entry : attendance.entrySet()) {
            String subject = entry.getKey();
            ArrayList<String> students = entry.getValue();
            System.out.println("\nSubject: " + subject + " (Total: " + students.size() + ")");
            for (String s : students) {
                System.out.println("  - " + s);
            }
        }
    }

    public static void main(String[] args) {
        SmartClassroomAttendanceTracker tracker = new SmartClassroomAttendanceTracker();

        tracker.markAttendance("Mathematics", "Alice");
        tracker.markAttendance("Mathematics", "Bob");
        tracker.markAttendance("Mathematics", "Alice"); // duplicate
        tracker.markAttendance("Physics", "Charlie");
        tracker.markAttendance("Physics", "Alice");
        tracker.markAttendance("Physics", "Charlie"); // duplicate
        tracker.markAttendance("Chemistry", "Diana");
        tracker.markAttendance("Chemistry", "Bob");

        tracker.displayAttendance();
    }
}
