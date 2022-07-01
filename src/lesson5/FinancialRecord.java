package lesson5;

public class FinancialRecord {
    private int income;
    private int outcome;

    public FinancialRecord(int income, int outcome) {
        this.income = income;
        this.outcome = outcome;
    }

    public int getIncome() {
        return this.income;
    }

    public int getOutcome() {
        return this.outcome;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setOutcome(int outcome) {
        this.outcome = outcome;
    }
}
