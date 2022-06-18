package lesson4.afterExtends;

public abstract class Animal {
    private int speed;

    public Animal(int speed) {
        this.speed = speed;
    }

    //final в определении метода запрещает перезаписывать (override) в классе наследнике
    public final void breath() {
        System.out.println("дышит");
    }

    public boolean isHumanFriend() {
        return false;
    }

    public abstract void run();
}
