package lesson6;

public class Boat {
    private String boatType;

    public Boat(String boatType) {
        this.boatType = boatType;
    }

    public void swim() {
        System.out.println("Лодка типа: " + this.boatType + " плывет");
    }
}
