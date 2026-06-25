
abstract class Vehicle{

    private String vehicleNumber;
    private String vehicleType;

    public String getVehicleNumber(){
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber){
        this.vehicleNumber=vehicleNumber;
    }

    public String getVehicleType(){
        return vehicleType;
    }

    public void setVehicleType(String vehicleType){
        this.vehicleType=vehicleType;
    }

    public void displayVehicle(){
        System.out.println("Vehicle Number : "+vehicleNumber);
        System.out.println("Vehicle Type : "+vehicleType);
    }

    abstract double calculateRentalCost(int days);
}

class Car extends Vehicle{

    private double dailyRate;

    public double getDailyRate(){
        return dailyRate;
    }

    public void setDailyRate(double dailyRate){
        this.dailyRate=dailyRate;
    }

    double calculateRentalCost(int days){
        return days*dailyRate;
    }
}

class Bike extends Vehicle{

    private double dailyRate;

    public double getDailyRate(){
        return dailyRate;
    }

    public void setDailyRate(double dailyRate){
        this.dailyRate=dailyRate;
    }

    double calculateRentalCost(int days){
        return days*dailyRate;
    }
}

class Truck extends Vehicle{

    private double dailyRate;
    private double loadingCharge;

    public double getDailyRate(){
        return dailyRate;
    }

    public void setDailyRate(double dailyRate){
        this.dailyRate=dailyRate;
    }

    public double getLoadingCharge(){
        return loadingCharge;
    }

    public void setLoadingCharge(double loadingCharge){
        this.loadingCharge=loadingCharge;
    }

    double calculateRentalCost(int days){
        return days*dailyRate+loadingCharge;
    }
}

public class VehicleRentalSystem{

    public static void main(String[] args){

        Car c=new Car();
        c.setVehicleNumber("UP32AA1111");
        c.setVehicleType("Car");
        c.setDailyRate(1500);

        Bike b=new Bike();
        b.setVehicleNumber("UP32BB2222");
        b.setVehicleType("Bike");
        b.setDailyRate(600);

        Truck t=new Truck();
        t.setVehicleNumber("UP32CC3333");
        t.setVehicleType("Truck");
        t.setDailyRate(3000);
        t.setLoadingCharge(5000);

        int days=5;

        c.displayVehicle();
        System.out.println("Rental Cost : "+c.calculateRentalCost(days));

        System.out.println();

        b.displayVehicle();
        System.out.println("Rental Cost : "+b.calculateRentalCost(days));

        System.out.println();

        t.displayVehicle();
        System.out.println("Rental Cost : "+t.calculateRentalCost(days));
    }
}
