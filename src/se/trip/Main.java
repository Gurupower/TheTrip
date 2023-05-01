package se.trip;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Lets go for a road trip");

        World world = new World();
        Trip trip = new Trip(world);

        trip.initTrip();
        int shop = trip.go("Pelle & Kajsa");
        System.out.printf("Did we shop: %s\n", shop >= 0 ? "Yes" : "No");
        shop = trip.go("Kalle is a friend");
        System.out.printf("Did we shop: %s\n", shop >= 0 ? "Yes" : "No");
    }
}
