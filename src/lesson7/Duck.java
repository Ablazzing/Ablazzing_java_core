package lesson7;

public class Duck implements Flyable {
    public boolean isInjured;

    public Duck(boolean isInjured) {
        this.isInjured = isInjured;
    }

    @Override
    public void fly() throws FlyException {
        try {
            if (isInjured) {
                throw new FlyException("подбита, падла");
            }  else {
                System.out.println("утка летит");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
