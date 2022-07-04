package homework4.lesson7advanced.Task1;

public class Spruce implements Tree {
    @Override
    public void canSmell() {
        System.out.println("ель умеет пахнуть");
    }

    @Override
    public void hasPinecones() {
        System.out.println("ель имеет шишки");
    }
}
