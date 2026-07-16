import java.util.List;

abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) { this.courseName = courseName; }
    public String getCourseName() { return courseName; }
    public abstract String getEvaluationType();
}

class ExamCourse extends CourseType {
    private int examWeightage;

    public ExamCourse(String name, int examWeightage) {
        super(name);
        this.examWeightage = examWeightage;
    }

    public int getExamWeightage() { return examWeightage; }
    public String getEvaluationType() { return "Exam-Based (Weightage: " + examWeightage + "%)"; }
}

class AssignmentCourse extends CourseType {
    private int totalAssignments;

    public AssignmentCourse(String name, int totalAssignments) {
        super(name);
        this.totalAssignments = totalAssignments;
    }

    public int getTotalAssignments() { return totalAssignments; }
    public String getEvaluationType() { return "Assignment-Based (Total: " + totalAssignments + " assignments)"; }
}

class ResearchCourse extends CourseType {
    private String researchTopic;

    public ResearchCourse(String name, String researchTopic) {
        super(name);
        this.researchTopic = researchTopic;
    }

    public String getResearchTopic() { return researchTopic; }
    public String getEvaluationType() { return "Research-Based (Topic: " + researchTopic + ")"; }
}

class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) { this.courseType = courseType; }
    public T getCourseType() { return courseType; }
}

class UniversityUtils {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getCourseName() + " - " + course.getEvaluationType());
        }
    }
}
