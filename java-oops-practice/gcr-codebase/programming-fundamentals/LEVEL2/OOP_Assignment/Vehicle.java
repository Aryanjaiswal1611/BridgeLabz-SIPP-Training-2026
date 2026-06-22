class Vehicle {

```
static double registrationFee =
        2000;

final String registrationNumber;

String ownerName;
String vehicleType;

public Vehicle(String ownerName,
               String vehicleType,
               String registrationNumber) {

    this.ownerName =
            ownerName;

    this.vehicleType =
            vehicleType;

    this.registrationNumber =
            registrationNumber;
}

public static void updateRegistrationFee(
        double fee) {

    registrationFee = fee;
}

public void display() {

    System.out.println(
            "Owner : "
                    + ownerName);

    System.out.println(
            "Type : "
                    + vehicleType);

    System.out.println(
            "Registration : "
                    + registrationNumber);

    System.out.println(
            "Fee : "
                    + registrationFee);
}

public static void main(String[] args) {

    Vehicle v =
            new Vehicle(
                    "Yash",
                    "Car",
                    "UP81AB1234"
            );

    if (v instanceof Vehicle) {
        v.display();
    }
}
```

}
