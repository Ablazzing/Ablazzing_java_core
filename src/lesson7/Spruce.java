package lesson7;

public class Spruce extends Tree implements Smellable {

    @Override
    public String canSmell() {
        return "может пахнуть";
    }
}
