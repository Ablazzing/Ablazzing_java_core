package lesson9.task;

public class Good {
    private String name;
    private int price;
    private int selfPrice;

    public Good(String name, int price, int selfPrice) {
        this.name = name;
        this.price = price;
        this.selfPrice = selfPrice;
    }

    @Override
    public String toString() {
        return String.format("%s;%d;%d", name, price, selfPrice);
    }

    public static Good of(String name, int price, int selfPrice) {
        return new Good(name, price, selfPrice);
    }
}
