package lesson5.expert;

import java.time.LocalDate;

public class ShopRecord {
    private String shop;
    private double income;
    private double outcome;
    private LocalDate date;

    public ShopRecord(String shop, double income, double outcome, LocalDate date) {
        this.shop = shop;
        this.income = income;
        this.outcome = outcome;
        this.date = date;
    }

    public String getShop() {
        return shop;
    }

    public double getIncome() {
        return income;
    }

    public double getOutcome() {
        return outcome;
    }

    public LocalDate getDate() {
        return date;
    }
}
