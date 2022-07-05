package lesson8;

public class Human {
    public String humanName = "op";

    public static void main(String[] args) {

        //Анонимный класс
        //Создание одного экземпляра из интерфейса, с переопределением абстрактных методов
        Fly fly = new Fly() {
            @Override
            public void fly() {
                System.out.println("Птица летает");
            }
        };

        //Создание вложенного статического экземпляра класса
        MyCar toyota = new Human.MyCar("toyota");

        //Создание вложенного нестатического экземпляра класса
        Human human = new Human();
        Hand leftHand = human.new Hand("left");
    }

    //Независимый класс внутри Lesson8Classes (для его создания не нужен экземпляр Lesson8Classes)
    public static class MyCar {
        private String name;

        public MyCar(String name) {
            this.name = name;
        }
    }

    //Зависимый класс (для его создания нужен экземпляр Human)
    public class Hand {
        private String name;

        public Hand(String name) {
            this.name = name;
        }

        public void sayHi() {
            System.out.println(humanName);
        }
    }
}
