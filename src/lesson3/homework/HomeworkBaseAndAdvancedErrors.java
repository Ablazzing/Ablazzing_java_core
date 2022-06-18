package lesson3.homework;

public class HomeworkBaseAndAdvancedErrors {
    public static void main(String[] args) {
        //Так делать не надо
        for (int i = 0; i < 10; i++) ;

        //Так надо
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        //Так делать не надо
        if (true)
        {

        }

        //Так надо
        if (true) {

        } else {

        }

        //Так делать не надо
        int age = 10;
        if (age < 7) {
            System.out.println("идет в сад");
        }
        if (age > 7 && age < 11) {
            System.out.println("Идет в младшую школу");
        }

        //Так надо
        if (age < 7) {
            System.out.println("идет в сад");
        } else if (age < 11) {
            System.out.println("Идет в младшую школу");
        } else if (age < 17) {
            System.out.println("Идет в среднюю школу");
        } else {

        }

        //Так делать не надо
        boolean vegetabels = true;
        boolean chicken = true;
        boolean sour = true;

        if (vegetabels == chicken == sour) {

        }

        // так тоже не надо
        if (vegetabels == true && chicken == true && sour == true) {

        }

        //Надо
        if (vegetabels && chicken && sour) {

        }

        //Так делать не надо
        Animal bear = new Animal("bear");
        Animal panda = new Animal("panda");

        //Так делать не надо
        Dog buggy = new Dog("Buggy");
        Bear bear1 = new Bear("Mikki");

        // Так делать не надо
        // Создание под каждую домашку нового репозитория
        // Надо работать в одном репозитории, который мы создали на первом занятии

        //Так делать не надо
        int result=1+1-3;
        // Так надо
        int result2 = 1 + 1 - 3;
    }
}
