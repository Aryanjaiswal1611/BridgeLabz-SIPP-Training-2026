public class FleetMain {
    public static void main(String[] args) {
        Vehicle[] fleet = { new Car(), new Bus(), new Bike(), new ElectricCar() };

        double km = 100;

        for (Vehicle v : fleet) {
            if (v instanceof Car) {
                Car c = (Car) v;
                System.out.println(c.type + " fuel cost for " + km + "km: $" + c.fuelCost(km));
            } else if (v instanceof Bus) {
                Bus b = (Bus) v;
                System.out.println(b.type + " fuel cost for " + km + "km: $" + b.fuelCost(km));
            } else if (v instanceof Bike) {
                Bike b = (Bike) v;
                System.out.println(b.type + " fuel cost for " + km + "km: $" + b.fuelCost(km));
            } else if (v instanceof ElectricCar) {
                ElectricCar e = (ElectricCar) v;
                System.out.println(e.type + " fuel cost for " + km + "km: $" + e.fuelCost(km));
            }
        }
    }
}
