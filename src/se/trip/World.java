package se.trip;

import java.util.ArrayList;

public class World {

    final int QTY_SHOPS = 15;

    ArrayList<Shop> shops = new ArrayList<>();

    void init() {
        for (int i = 0; i < QTY_SHOPS; i++) {
            shops.add(new Shop());
        }
    }

    int findCheapestShop() {
        int lowestPrice = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < shops.size(); i++) {
            if (shops.get(i).getPrice() < lowestPrice) {
                lowestPrice = shops.get(i).getPrice();
                index = i;
            }
        }

        System.out.printf("Cheapest shop is number %d, price %d\n", index + 1, lowestPrice);
        return index;
    }
}
