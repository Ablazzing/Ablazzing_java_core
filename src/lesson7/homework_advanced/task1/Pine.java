package lesson7.homework_advanced.task1;

public class Pine extends Tree implements Smellable {
    private boolean hasCone;

    public Pine(boolean hasCone) {
        this.hasCone = hasCone;
    }

    @Override
    public void smell() {
        System.out.println("сосна пахнет");
    }
}
