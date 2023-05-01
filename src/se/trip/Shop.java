package se.trip;

import se.trip.FruitBasket;

import java.util.ArrayList;
import java.util.Random;

public class Shop {

    static final int MAX_PRICE = 100;

    //indexes for fruits
    static final int CHERRIES = 0;
    static final int PEACH = 1;
    static final int NO_FRUITS = 2;

    boolean stock = true;
    ArrayList<FruitBasket> baskets = new ArrayList<>();

    Shop() {
        Random random = new Random();
        for (int i = 0; i < NO_FRUITS; i++) {
            baskets.add(new FruitBasket(true, random.nextInt(MAX_PRICE)));
        }
        System.out.println(this);
    }

    int getPrice() {
        int sum = 0;
        for (int i = 0; i < NO_FRUITS; i++) {
            sum = sum + baskets.get(i).price;
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shop - ");
        for (FruitBasket fb : baskets) {
            sb.append(" Prices: ").append(fb.price);
        }
        sb.append(" Total: ").append(getPrice());
        return sb.toString();
    }
}
