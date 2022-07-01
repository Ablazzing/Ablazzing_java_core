package homework4.lesson7basic;

public class Duck implements FlyingObject {

    public boolean isInjured;

    public Duck(boolean isInjured) {
        this.isInjured = isInjured;
    }

    @Override
    public void canFly() throws FlyException {
        if (isInjured) {
            throw new FlyException("Ошибка: утка ранена");
        }
        System.out.println("утка летит");

    }
}
