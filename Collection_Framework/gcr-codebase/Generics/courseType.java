import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    String name;

    CourseType(String name) {
        this.name = name;
    }

    public String toString() {
        return getClass().getSimpleName() + " : " + name;
    }
}

class ExamCourse extends CourseType {
    ExamCourse(String name) {
        super(name);
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String name) {
        super(name);
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String name) {
        super(name);
    }
}

class Course<T extends CourseType> {

    private List<T> courses = new ArrayList<>();

    void addCourse(T course) {
        courses.add(course);
    }

    List<T> getCourses() {
        return courses;
    }
}

public class UniversityDemo {

    static void displayCourses(List<? extends CourseType> list) {
        for (CourseType c : list) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {

        Course<ExamCourse> exam = new Course<>();
        exam.addCourse(new ExamCourse("Operating System"));

        Course<AssignmentCourse> assignment = new Course<>();
        assignment.addCourse(new AssignmentCourse("Java"));

        displayCourses(exam.getCourses());
        displayCourses(assignment.getCourses());
    }
}