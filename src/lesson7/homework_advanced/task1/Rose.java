package lesson7.homework_advanced.task1;

public class Rose extends Plant implements Smellable, Bloomable {

    @Override
    public void bloom() {
        System.out.println("роза цветет");
    }

    @Override
    public void smell() {
        System.out.println("роза пахнет");
    }
}
