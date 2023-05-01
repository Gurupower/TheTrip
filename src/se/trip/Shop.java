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
    String[] fruitList = new String[]{"CHERRIES", "PEACH", "PEARS"};

    ArrayList<FruitBasket> baskets = new ArrayList<>();

    Shop() {
        Random random = new Random();
        for (int i = 0; i < NO_FRUITS; i++) {
            baskets.add(new FruitBasket(random.nextBoolean(), random.nextInt(MAX_PRICE), fruitList[i]));
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
        sum = sum + (baskets.get(CHERRIES).cheapest(baskets.get(PEACH))).price;
        return sum;
    }

    String shop() {
        StringBuilder sb = new StringBuilder();
        sb.append(baskets.get(PEARS)).append(", ");
        baskets.get(PEARS).stock = false;
        FruitBasket basket = baskets.get(CHERRIES).cheapest(baskets.get(PEACH));
        sb.append(basket);
        basket.stock = false;
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
