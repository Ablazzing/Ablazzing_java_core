package lesson9.task;

public class Report {
    private Good good;
    private int count;
    private Discount discount;

    public Report(Good good, int count, Discount discount) {
        this.good = good;
        this.count = count;
        this.discount = discount;
    }

    public Good getGood() {
        return good;
    }

    public int getCount() {
        return count;
    }

    public Discount getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return String.join(";", good.toString(), String.valueOf(count), String.valueOf(discount.name()));
    }
}
