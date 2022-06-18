package lesson4.afterExtends;

public class Horse  extends Animal{

    public Horse(int speed) {
        super(speed);
    }

    public String makeSound() {
        return "ржет!";
    }

    @Override
    public boolean isHumanFriend() {
        return true;
    }

    @Override
    public void run() {

    }
}
