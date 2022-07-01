package lesson7;

public class Fern extends Flower implements Bloomable  {

    @Override
    public String canBloom() {
        return "умеет цвести";
    }
}
