// Problem 1: University System - Multilevel Inheritance
// Person -> Student -> GradStudent
// Demonstrates: super() chaining, final fields, toString() overriding, IS-A relationship

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person constructor called");
    }

    @Override
    public String toString() {
        return "Person[ name=" + name + ", age=" + age + " ]";
    }
}

class Student extends Person {
    private final int studentId;  // final field
    protected double gpa;

    public Student(String name, int age, int studentId, double gpa) {
        super(name, age);  // chaining to Person constructor
        this.studentId = studentId;
        this.gpa = gpa;
        System.out.println("Student constructor called");
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student[ " + super.toString() + ", studentId=" + studentId + ", gpa=" + gpa + " ]";
    }
}

class GradStudent extends Student {
    private String thesis;

    public GradStudent(String name, int age, int studentId, double gpa, String thesis) {
        super(name, age, studentId, gpa);  // chaining to Student constructor
        this.thesis = thesis;
        System.out.println("GradStudent constructor called");
    }

    @Override
    public String toString() {
        return "GradStudent[ " + super.toString() + ", thesis='" + thesis + "' ]";
    }
}

public class Problem1_University {
    public static void main(String[] args) {
        System.out.println("\n--- Problem 1: University System ---\n");

        // Demonstrate IS-A relationship
        GradStudent gs = new GradStudent("Alice", 25, 101, 3.9, "Machine Learning");

        System.out.println("\n--- toString() outputs ---");
        System.out.println(gs);

        // IS-A checks
        System.out.println("\n--- IS-A Relationship Demo ---");
        System.out.println("GradStudent IS-A Student: " + (gs instanceof Student));
        System.out.println("GradStudent IS-A Person: " + (gs instanceof Person));
        System.out.println("Student IS-A Person: " + (gs instanceof Person));

        // Polymorphism
        Person p = gs;          // GradStudent IS-A Person
        Student s = gs;         // GradStudent IS-A Student
        System.out.println("Person reference: " + p);
        System.out.println("Student reference: " + s);

        // Final field - cannot be reassigned
        // s.getStudentId() works; studentId is final
        System.out.println("Student ID (final): " + gs.getStudentId());
    }
}
