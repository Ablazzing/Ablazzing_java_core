package lesson7;

public class Watch implements Tickable{
    public boolean isBroken;

    public Watch(boolean isBroken) {
        this.isBroken = isBroken;
    }

    @Override
    public void tick() {
        try {
            if (!isBroken) {
                System.out.println("tick");
            } else {
                throw new TickException("broken");
            }
        } catch (TickException e) {
            System.out.println(e);
        }
    }
}
