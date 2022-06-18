package lesson3;

public class Employee {

    private String name;
    private Stock stock;
    private int journal = 0;

    public Employee(String name, Stock stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void destroyVodka() {
        this.stock.reduceVodka();
        System.out.println("Ура я испортил водку!");
        this.journal += 1;
    }

    public int getJournal() {
        return journal;
    }
}
