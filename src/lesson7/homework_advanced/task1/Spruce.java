package lesson7.homework_advanced.task1;

public class Spruce extends Tree implements Smellable {
    private boolean hasCone;

    public Spruce(boolean hasCone) {
        this.hasCone = hasCone;
    }

    @Override
    public void smell() {
        System.out.println("ель пахнет");
    }
}
