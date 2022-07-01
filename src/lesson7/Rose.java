package lesson7;

public class Rose implements Flower, Tree{
    @Override
    public String canBloom() {
        return "умеет цвести";
    }

    @Override
    public String canSmell() {
        return "умеет пахнуть";
    }
}
