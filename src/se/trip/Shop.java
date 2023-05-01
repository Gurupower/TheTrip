package se.trip;

import java.util.ArrayList;
import java.util.Random;

public class Shop {

    static final int MAX_PRICE = 100;

    //indexes for fruits
    static final int CHERRIES = 0;
    static final int PEACH = 1;
    static final int PEARS = 2;
    static final int NO_FRUITS = 3;

    ArrayList<FruitBasket> baskets = new ArrayList<>();

    Shop() {
        Random random = new Random();
        for (int i = 0; i < NO_FRUITS; i++) {
            baskets.add(new FruitBasket(random.nextBoolean(), random.nextInt(MAX_PRICE)));
        }
        System.out.println(this);
    }

    boolean hasStock() {
        return (baskets.get(PEARS).stock && baskets.get(CHERRIES).stock || baskets.get(PEACH).stock);
    }

    int getTotalPrice() {
        int sum = 0;
        for (int i = 0; i < NO_FRUITS; i++) {
            sum = sum + baskets.get(i).price;
        }
        return sum;
    }

    int getMinPriceForPearsPlusOne() {
        int sum = baskets.get(PEARS).price;
        sum = sum + Math.min(baskets.get(CHERRIES).price, baskets.get(PEACH).price);
        return sum;
    }

    String shop() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pear, ");
        if (baskets.get(CHERRIES).price < baskets.get(PEACH).price) {
            sb.append("Cherries");
        } else {
            sb.append("Peach");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shop - has Stock: ").append(hasStock() ? "Yes" : "No");
        for (FruitBasket fb : baskets) {
            sb.append(" Prices: ").append(fb.price);
        }
        sb.append(" Pear + One: ").append(getMinPriceForPearsPlusOne());
        sb.append(" Total: ").append(getTotalPrice());
        return sb.toString();
    }
}
