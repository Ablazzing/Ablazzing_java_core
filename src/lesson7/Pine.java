package lesson7;

public class Pine extends Tree implements Smellable{

    @Override
    public String canSmell() {
        return "может пахнуть";
    }
}
