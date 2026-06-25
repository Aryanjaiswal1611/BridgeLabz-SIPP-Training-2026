public class LibraryMain {
    static void printMemberDetails(LibraryMember[] members) {
        for (LibraryMember m : members) {
            m.displayDetails();
        }
    }

    static void findMemberById(LibraryMember[] members, String searchId) {
        for (LibraryMember m : members) {
            if (m.memberId.equals(searchId)) {
                System.out.print("Member found: ");
                m.displayDetails();
                return;
            }
        }
        System.out.println("No member found with ID: " + searchId);
    }

    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentMember("Alice", "S001"),
            new FacultyMember("Dr. Smith", "F001"),
            new GuestMember("Bob", "G001"),
            new StudentMember("Charlie", "S002"),
            new FacultyMember("Prof. Jones", "F002")
        };

        System.out.println("=== Member Details ===");
        printMemberDetails(members);

        System.out.println("\n=== Fine Calculations (5 overdue days) ===");
        for (LibraryMember m : members) {
            System.out.print(m.memberName + " fine: $" + m.calculateFine(5) + " | ");
            m.displayDetails();
        }

        System.out.println("\n=== Search Member by ID ===");
        findMemberById(members, "F001");
        findMemberById(members, "S002");
        findMemberById(members, "X001");
    }
}
