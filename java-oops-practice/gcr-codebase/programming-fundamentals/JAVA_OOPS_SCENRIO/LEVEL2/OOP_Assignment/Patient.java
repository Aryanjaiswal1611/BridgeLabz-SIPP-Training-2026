class Patient {

```
static String hospitalName =
        "City Hospital";

static int totalPatients = 0;

String name;
int age;
String ailment;

final int patientID;

public Patient(String name,
               int age,
               String ailment,
               int patientID) {

    this.name = name;
    this.age = age;
    this.ailment = ailment;
    this.patientID = patientID;

    totalPatients++;
}

public static void getTotalPatients() {

    System.out.println(
            "Total Patients : "
                    + totalPatients);
}

public void display() {

    System.out.println(
            "Patient : " + name);

    System.out.println(
            "Age : " + age);

    System.out.println(
            "Ailment : " + ailment);

    System.out.println(
            "Patient ID : "
                    + patientID);
}

public static void main(String[] args) {

    Patient p =
            new Patient(
                    "Rahul",
                    25,
                    "Fever",
                    1001
            );

    if (p instanceof Patient) {
        p.display();
    }

    getTotalPatients();
}
```

}
