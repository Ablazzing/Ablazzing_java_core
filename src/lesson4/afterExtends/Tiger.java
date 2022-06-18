package lesson4.afterExtends;

//final при объявлении класса, запрещает наследоваться
public final class Tiger extends Animal{

    public Tiger(int speed) {
        super(speed);
    }

    public String makeSound() {
        return "шипит!";
    }

    @Override
    public void run() {
        System.out.println("тигр бежит со скоростью" );
    }
}
