package lesson7.pro_task1;

public class Pine extends Tree implements Smellable{

    @Override
    public String canSmell() {
        return "может пахнуть";
    }
}
