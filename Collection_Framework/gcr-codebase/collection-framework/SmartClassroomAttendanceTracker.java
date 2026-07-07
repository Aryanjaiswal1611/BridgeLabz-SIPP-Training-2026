import java.util.*;

public class SmartClassroomAttendanceTracker {

    HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    // Mark Attendance
    public void markAttendance(String subject, String student) {

        attendance.putIfAbsent(subject, new ArrayList<>());

        ArrayList<String> students = attendance.get(subject);

        if (students.contains(student)) {
            System.out.println(student + " is already marked present in " + subject);
        } else {
            students.add(student);
            System.out.println(student + " marked present in " + subject);
        }
    }

    // Display Attendance
    public void displayAttendance() {

        System.out.println("\nAttendance Record:");

        for (String subject : attendance.keySet()) {

            System.out.println("\nSubject: " + subject);

            ArrayList<String> students = attendance.get(subject);

            for (String student : students) {
                System.out.println(student);
            }

            System.out.println("Total Students Present: " + students.size());
        }
    }

    public static void main(String[] args) {

        SmartClassroomAttendanceTracker tracker =
                new SmartClassroomAttendanceTracker();

        tracker.markAttendance("Java", "Pratik");
        tracker.markAttendance("Java", "Rahul");
        tracker.markAttendance("Python", "Aman");
        tracker.markAttendance("Python", "Pratik");

        // Duplicate Attendance
        tracker.markAttendance("Java", "Pratik");

        tracker.displayAttendance();
    }
}