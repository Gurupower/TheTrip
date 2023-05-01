package se.trip;

public class FruitBasket {

    boolean stock;
    int price;
    String fruit;

    FruitBasket(boolean s, int p, String f) {
        stock = s;
        price = p;
        fruit = f;
    }

    FruitBasket cheapest(FruitBasket obj) {
        FruitBasket returnBasket = obj;
        if (this.stock && obj.stock) {
            returnBasket = this.price < obj.price ? this : obj;
        } else {
            returnBasket = this.stock ? this : obj;
        } // Ignore when non
        return returnBasket;
    }

    @Override
    public String toString() {
        return fruit;
    }
}
