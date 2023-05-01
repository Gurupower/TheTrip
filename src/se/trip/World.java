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

    int findCheapestShop(String name) {
        int lowestPrice = Integer.MAX_VALUE;
        int index = -1;
        int shopsAvailable = 0;
        for (int i = 0; i < shops.size(); i++) {
            Shop s = shops.get(i);
            if (s.hasStock()) {
                shopsAvailable++;
                if (shops.get(i).getMinPriceForPearsPlusOne() < lowestPrice) {
                    lowestPrice = shops.get(i).getMinPriceForPearsPlusOne();
                    index = i;
                }
            }
        }
        String fruits = shops.get(index).shop();
        System.out.printf(name + " Road Trip. \n");
        System.out.printf("The cheapest shop is number %d, price %d with the fruits %s, total shops with stock was %d\n", index + 1, lowestPrice, fruits, shopsAvailable);
        return index;
    }
}
