package se.trip;

public class Trip {

    World world;

    Trip(World w) {
        world = w;
    }

    void initTrip() {
        world.init();
    }

    int go(String name) {
        return world.findCheapestShop(name);
    }
}
