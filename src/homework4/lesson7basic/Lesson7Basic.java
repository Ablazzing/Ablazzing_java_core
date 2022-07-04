package homework4.lesson7basic;

public class Lesson7Basic {
    public static void main(String[] args) throws FlyException {
        Duck healthyDuck = new Duck(false);
        try {
            healthyDuck.canFly();

        } catch (FlyException e) {
            System.out.println(e.getMessage());
        }

        Duck injuredDuck = new Duck(true);
        try {
            injuredDuck.canFly();
        } catch (FlyException e) {
            System.out.println(e.getMessage());
        }

        Plane rightPlane = new Plane(10);
        try {
            rightPlane.canFly();
        } catch (FlyException e) {
            System.out.println(e.getMessage());
        }

        Plane wrongPlane = new Plane(-1);

        try {
            wrongPlane.canFly();
        } catch (FlyException e) {
            System.out.println(e.getMessage());
        }
    }
}
