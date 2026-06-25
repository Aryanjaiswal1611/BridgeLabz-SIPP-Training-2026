class Vehicle {
    String type;

    Vehicle(String type) {
        this.type = type;
    }

    double fuelCost(double km) {
        return 0;
    }
}

class Car extends Vehicle {
    Car() {
        super("Car");
    }

    @Override
    double fuelCost(double km) {
        return km * 0.08;
    }
}

class Bus extends Vehicle {
    Bus() {
        super("Bus");
    }

    @Override
    double fuelCost(double km) {
        return km * 0.20;
    }
}

class Bike extends Vehicle {
    Bike() {
        super("Bike");
    }

    @Override
    double fuelCost(double km) {
        return km * 0.03;
    }
}

class ElectricCar extends Vehicle {
    ElectricCar() {
        super("ElectricCar");
    }

    @Override
    double fuelCost(double km) {
        return km * 0.05;
    }
}
