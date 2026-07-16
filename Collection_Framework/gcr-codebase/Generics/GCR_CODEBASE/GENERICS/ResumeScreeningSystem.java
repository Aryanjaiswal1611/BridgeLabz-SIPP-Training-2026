import java.util.List;

abstract class JobRole {
    private String title;

    public JobRole(String title) { this.title = title; }
    public String getTitle() { return title; }
    public abstract List<String> getRequiredSkills();
}

class SoftwareEngineer extends JobRole {
    private String programmingLanguage;
    private String framework;

    public SoftwareEngineer(String programmingLanguage, String framework) {
        super("Software Engineer");
        this.programmingLanguage = programmingLanguage;
        this.framework = framework;
    }

    public String getProgrammingLanguage() { return programmingLanguage; }
    public String getFramework() { return framework; }
    public List<String> getRequiredSkills() {
        return List.of(programmingLanguage, framework, "Data Structures", "Algorithms", "System Design");
    }
}

class DataScientist extends JobRole {
    private String domain;
    private String tool;

    public DataScientist(String domain, String tool) {
        super("Data Scientist");
        this.domain = domain;
        this.tool = tool;
    }

    public String getDomain() { return domain; }
    public String getTool() { return tool; }
    public List<String> getRequiredSkills() {
        return List.of("Python", "Statistics", "Machine Learning", domain, tool);
    }
}

class ProductManager extends JobRole {
    private int experience;
    private String industry;

    public ProductManager(int experience, String industry) {
        super("Product Manager");
        this.experience = experience;
        this.industry = industry;
    }

    public int getExperience() { return experience; }
    public String getIndustry() { return industry; }
    public List<String> getRequiredSkills() {
        return List.of("Product Strategy", "Agile Methodologies", "User Research", industry, "Data Analysis");
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;
    private int score;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
        this.score = 0;
    }

    public String getCandidateName() { return candidateName; }
    public T getJobRole() { return jobRole; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}

class ScreeningUtils {
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        int score = resume.getJobRole().getRequiredSkills().size() * 10;
        resume.setScore(score);
    }

    public static void processMultipleResumes(List<? extends JobRole> jobRoles) {
        for (JobRole role : jobRoles) {
            System.out.println("Processing: " + role.getTitle());
        }
    }
}
