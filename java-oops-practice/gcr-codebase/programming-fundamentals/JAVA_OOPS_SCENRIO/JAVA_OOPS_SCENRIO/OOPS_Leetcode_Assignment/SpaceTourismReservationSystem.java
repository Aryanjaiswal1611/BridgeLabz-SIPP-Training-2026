class SpaceTourist {

    static int totalReservations = 0;
    static String missionName = "Moon Explorer";

    String touristName;
    int seatNumber;

    public SpaceTourist(String touristName, int seatNumber) {
        this.touristName = touristName;
        this.seatNumber = seatNumber;
        totalReservations++;
    }

    public SpaceTourist updateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public void displayDetails() {
        System.out.println("Mission: " + missionName);
        System.out.println("Tourist: " + touristName);
        System.out.println("Seat Number: " + seatNumber);
    }

    public static void main(String[] args) {

        SpaceTourist tourist =
                new SpaceTourist("Yash", 5);

        tourist.updateSeatNumber(10)
               .updateSeatNumber(15);

        tourist.displayDetails();

        System.out.println(
                "Total Reservations: "
                        + totalReservations);
    }
}