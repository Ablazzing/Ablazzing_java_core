package lesson4.beforeExtends;

public class Animal {
    private String name;
    private int speed;

    public Animal(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void makeSound() {
        if (this.name.equals("тигр")) {
            System.out.println("шипит!");
        } else if (this.name.equals("лошадь")) {
            System.out.println("ржет!");
        }
    }

    public void run() {
        System.out.println(this.name + " бежит со скоростью" + this.speed );
    }
}
