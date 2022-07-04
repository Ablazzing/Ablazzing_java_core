package homework4.lesson7advanced.Task1;

public class Pine implements Tree {
    @Override
    public void canSmell() {
        System.out.println("сосна умеет пахнуть");
    }

    @Override
    public void hasPinecones() {
        System.out.println("сосна имеет шишки");
    }
}
