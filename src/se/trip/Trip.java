package se.trip;

public class Trip {

    World world;
    Trip(World w) {
        world = w;
    }

    void initTrip() {
        world.init();
    }

    int go() {
        return world.findCheapestShop();
    }
}
