package lesson1;

public class TypicalErrors {
    public static void main(String[] args) {
        /* Стилистика кода */
        /* Большое количество пустых строк между строками кода (должно быть не больше одного пропуска) */
        //Вместо
        String hi = "hello";
        System.out.println(hi);



        double growth = 1.69;
        System.out.println(growth);

        //Нужно
        String hi2 = "hello";
        System.out.println(hi);

        double growth2 = 1.69;
        System.out.println(growth);

        /* Лишние отступы */
        //Вместо
        String some1 = "";
            String some2 = "kkk";
        //Надо (ctrl + a потом ctrl + alt + l)
        String some3 = "";
        String some4 = "sss";
       boolean b1 = false;
       int i = 0;
       short s1= 0;

        /* Фигурная скобка находится на том же уровне, что и ключевое слово. */
        // Вместо
        if (true)
        {
        }

        // Надо
        if (true) {

        }

        /* Использование if в одну строку */
        // Вместо
        if (true) System.out.println();
        //Надо
        if (true) {
            System.out.println();
        }

        /* Именование переменных их типом */
        // Вместо
        String string = "text";
        //Надо
        String text = "text";

        /* Отсутствие пробелов до и после =, ==, +,- */
        // Вместо
        int k=1+1;
        //Надо
        int kRight = 1 + 1;

        /* Использование var, вместо обычной переменной */
        // Вместо
        var textVar = "текст";
        // Надо
        String textRight = "текст";
    }
}
