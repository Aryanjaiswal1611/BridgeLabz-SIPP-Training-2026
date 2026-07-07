import java.util.ArrayList;
import java.util.List;

abstract class JobRole {

    String role;

    JobRole(String role) {
        this.role = role;
    }

    public String toString() {
        return getClass().getSimpleName() + " : " + role;
    }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer(String role) {
        super(role);
    }
}

class DataScientist extends JobRole {
    DataScientist(String role) {
        super(role);
    }
}

class ProductManager extends JobRole {
    ProductManager(String role) {
        super(role);
    }
}

class Resume<T extends JobRole> {

    T role;

    Resume(T role) {
        this.role = role;
    }

    T getRole() {
        return role;
    }
}

public class ResumeDemo {

    static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Processing " + resume.getRole());
    }

    static void screening(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println(role);
        }
    }

    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 =
                new Resume<>(new SoftwareEngineer("Backend Engineer"));

        Resume<DataScientist> r2 =
                new Resume<>(new DataScientist("ML Engineer"));

        processResume(r1);
        processResume(r2);

        List<JobRole> list = new ArrayList<>();
        list.add(new SoftwareEngineer("Java Developer"));
        list.add(new DataScientist("AI Engineer"));
        list.add(new ProductManager("Product Owner"));

        screening(list);
    }
}