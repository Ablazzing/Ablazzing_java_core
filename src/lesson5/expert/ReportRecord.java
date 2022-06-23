package lesson5.expert;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ReportRecord {
    private String shop;
    private double income;
    private double outcome;
    private String date;

    public ReportRecord(String shop, double income, double outcome, String date) {
        this.shop = shop;
        this.income = income;
        this.outcome = outcome;
        this.date = date;
    }

    @Override
    public String toString() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("0.00", decimalFormatSymbols);
        return String.join(";", shop, decimalFormat.format(income),
                decimalFormat.format(outcome), date);
    }
}
