package lesson7.pro_task1;

public class Rose extends Flower implements Bloomable, Smellable{
    @Override
    public String canBloom() {
        return "умеет цвести";
    }

    @Override
    public String canSmell() {
        return "умеет пахнуть";
    }
}
