package lesson6;

public class Fish {
    private int weight;

    public Fish(int weight) {
        this.weight = weight;
    }

    public void swim() {
        System.out.println("Рыба весом " + this.weight + "кг поплыла");
    }
}
