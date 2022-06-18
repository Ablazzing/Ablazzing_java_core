package homework2.lesson3basic;

public class Lesson3Basic {
    public static void main(String[] args) {
        // Домашка
        // Базовый уровень
        // Задание №1 - Написать цикл, который выводит через пробел 100 чисел с приставкой "a".
        // Ожидаемый результат: 1а 2а 3а .. 100а
        String aNumber = "";
        String a = "a";
        for (int i = 0; i < 101; i++) {
            aNumber += a + i + " ";
        }
        System.out.println(aNumber.trim());
        //
        // Задание №2
        // Задача: Написать условную конструкцию, которая в зависимости от возраста ребенка, отправляет его в учебное заведение
        // если ребенку до 6 лет то в сад, если до 11 лет в младшую школу, если до 17 лет в среднюю школу, иначе в университет
        // Отправляет - имеется в виду, печатает на экран: "пошел с сад", "пошел в младшую школу" и т.д.
        // Проверьте работоспособность условий, через изменение значения переменной.
        // Дано:
        int ageChildren = 18;


        if (ageChildren < 7) {
            System.out.println("пошел в сад");
        } else if ( ageChildren < 11) {
            System.out.println("пошел в младшую школу");
        } else if ( ageChildren < 17) {
            System.out.println("пошел в среднюю школу");
        } else {
            System.out.println("пошел в университет");
        }

        // Задание №3
        // Дано:
        boolean chicken = false;
        boolean vegetables = true;
        boolean sour = true;
        boolean toast = true;
        boolean sausage = true;
        boolean eggs = true;
        // Задача: Повара попросили сделать салат.
        // Если у повара есть все ингредиенты для "Цезаря" (курица, овощи, соус и гренки), то лучше сделать "Цезарь".
        // Если для "Цезаря" ингредиентов не нашлось, то сделать Оливье (овощи, колбаса или курица, яйца).
        // Если и для Оливье не нашлось ингредиентов, то сделать Овощной салат (нужны только овощи).
        // Если ингредиентов нет, то повар объявляет: У меня ничего нет
        // Написать набор условий, приготовления салатов, по приоритету (от Цезаря к овощному). Либо объявить о невозможности сделать салат.
        // Ожидаемый результат: вывод на экран сделанного салата или объявление о том, что ничего нет.
        // Проверьте работоспособность условий, через изменение значения переменных.


        boolean cesar = chicken && vegetables && sour && toast;
        boolean olivier = vegetables && sausage || chicken && eggs && !toast;
        boolean vegSalad = vegetables && !chicken && !eggs;
        boolean haveNoIngredients = !vegetables;

        if (cesar) {
            System.out.println("Повару лучше бы сделать этот чертов \"Цезарь\"!");
        }else if (olivier) {
            System.out.println("Повару лучше бы сделать этот чертов \"Оливье\"!");
        } else if (vegSalad) {
            System.out.println("Повару лучше бы сделать этот чертов \"Овощной салатик\"!");
        } else if (haveNoIngredients) {
            System.out.println("Повар объявляет: У меня ничего нет ");
        }


        // Задание №4
        // Создать два класса, которые описывают какое либо животное (имеют два атрибута).
        // Написать к ним конструктор, сеттеры, геттеры.

        Dog.setName("jack");
        Animal.setKind("mammal");
        Animal.setSubKind("canine");
        Dog dog = new Dog(Dog.getName(),Animal.getKind(), Animal.getSubKind());
        System.out.println(dog);

    }
}
