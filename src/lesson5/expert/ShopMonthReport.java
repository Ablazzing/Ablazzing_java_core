package lesson5.expert;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ShopMonthReport {
    private String name;
    private double totalIncome;
    private double totalOutcome;
    private int month;
    private int year;

    public ShopMonthReport(String name, double totalIncome, double totalOutcome, int month, int year) {
        this.name = name;
        this.totalIncome = totalIncome;
        this.totalOutcome = totalOutcome;
        this.month = month;
        this.year = year;
    }

    public void incrementIncome(double income) {
        this.totalIncome += income;
    }

    public void incrementOutcome(double outcome) {
        this.totalOutcome += outcome;
    }

    public String getName() {
        return name;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalOutcome() {
        return totalOutcome;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("0.00", decimalFormatSymbols);
        return String.format("%d.%d: %s", month, year, decimalFormat.format(totalIncome - totalOutcome));
    }
}
