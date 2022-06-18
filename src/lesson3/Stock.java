package lesson3;

public class Stock {

    private int vodka = 100;

    public int getVodka() {
        return vodka;
    }

    public void setVodka(int vodka) {
        this.vodka = vodka;
    }

    public void reduceVodka() {
        this.vodka -= 1;
    }
}
