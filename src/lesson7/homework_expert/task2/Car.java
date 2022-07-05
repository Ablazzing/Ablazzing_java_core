package lesson7.homework_expert.task2;

public class Car {
    private int price;

    public Car(int price) {
        this.price = price;
    }

    public void showPrice() throws Exception {
        if (price < 0) {
            throw new Exception("Ошибка: меньше нуля стоимость");
        }
        System.out.println(price);
    }
}
