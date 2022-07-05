package lesson9.task;

public enum Discount {
    NONE(1),
    STUDENT(0.95),
    PENSIONER(0.90),
    DOCTOR(0.85);

    private double discount;

    Discount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
