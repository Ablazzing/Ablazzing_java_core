package lesson5.expert;

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
        return String.join(";", shop, String.valueOf(income), String.valueOf(outcome), date);
    }
}
