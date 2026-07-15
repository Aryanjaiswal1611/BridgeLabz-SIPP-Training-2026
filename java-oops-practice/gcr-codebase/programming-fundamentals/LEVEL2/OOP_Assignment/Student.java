class Student {

```
static String universityName =
        "GLA University";

static int totalStudents = 0;

String name;
final int rollNumber;
char grade;

public Student(String name,
               int rollNumber,
               char grade) {

    this.name = name;
    this.rollNumber = rollNumber;
    this.grade = grade;

    totalStudents++;
}

public static void displayTotalStudents() {

    System.out.println(
            "Total Students : "
                    + totalStudents);
}

public void display() {

    System.out.println(
            "Name : " + name);

    System.out.println(
            "Roll No : "
                    + rollNumber);

    System.out.println(
            "Grade : "
                    + grade);
}

public static void main(String[] args) {

    Student s =
            new Student(
                    "Yash",
                    101,
                    'A'
            );

    if (s instanceof Student) {
        s.display();
    }

    displayTotalStudents();
}
```

}
