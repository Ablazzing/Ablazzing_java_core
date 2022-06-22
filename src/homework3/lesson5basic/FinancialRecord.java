package homework3.lesson5basic;

public class FinancialRecord {
    private String incomes;
    private String outcomes;

    public FinancialRecord(String incomes, String outcomes) {
        this.incomes = incomes;
        this.outcomes = outcomes;
    }

    public String getIncomes() {
        return incomes;
    }

    public void setIncomes(String incomes) {
        this.incomes = incomes;
    }

    public String getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(String outcomes) {
        this.outcomes = outcomes;
    }
}
