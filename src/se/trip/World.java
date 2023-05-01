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
            Shop s = shops.get(i);
            if (s.hasStock() && shops.get(i).getMinPriceForPearsPlusOne() < lowestPrice) {
                lowestPrice = shops.get(i).getMinPriceForPearsPlusOne();
                index = i;
            }
        }
        String fruits = shops.get(index).shop();
        System.out.printf("Cheapest shop is number %d, price %d %s\n", index + 1, lowestPrice, fruits);
        return index;
    }
}
