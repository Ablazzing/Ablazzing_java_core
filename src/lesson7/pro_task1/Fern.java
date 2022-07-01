package lesson7.pro_task1;

public class Fern extends Flower implements Bloomable  {

    @Override
    public String canBloom() {
        return "умеет цвести";
    }
}
