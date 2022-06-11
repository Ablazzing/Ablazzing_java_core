package lesson1.Expert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeworkExpertErrors {
    public static void main(String[] args) {
        /*  При переборе элементов массива, если не нужен их индекс, лучше использовать for each. */
        // Вместо
        String[] words = {"слово первое", "слово второе"};
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        // Надо
        for (String word : words) {
            System.out.println(word);
        }

        /*  При объединении слов с одинаковым разделителем, нужно использовать String.join. */
        // Вместо
        String join = "слово1" + ";" + "слово2" + ";" + "слово3";


        // Надо
        String joinRight = String.join(";", "слово1", "слово2", "слово3");

        /* Использование считывателя с командной строки, для тестирования решения,
         А если в задании нет требования считывать с командной строки - не использовать вовсе.
         Надо создать переменную с этими данными */

        // Игнорирование условия задачи. Если указано создание метода с входящим типом String,
        // То не нужно создавать метод с входящим типом StringBuffer
        // Вместо
        // public static void mask(StringBuffer string) {
        // Надо
        // public static String mask(String text) {

        //Использование static полей класса, когда не понимаешь зачем это надо. Используй переменные и аргументы в функциях.

        /* Написание в одну строку длинного предложения */
        // Вместо
        String[] nameArray = new String[]{};
        int i = 1;
        String lastName = nameArray[i].charAt(0) + "*".repeat(nameArray[i].length() - 2) + nameArray[i].substring(nameArray[i].length() - 1, nameArray[0].length());

        // Надо
        String lastNameRight = nameArray[i].charAt(0)
                + "*".repeat(nameArray[i].length() - 2)
                + nameArray[i].substring(nameArray[i].length() - 1, nameArray[0].length());

        /* Использование переменной, для разного по смыслу данных */
        // Вместо
        String PatternString = "<data>.*</data>";
        PatternString = "\\d+"; // Шаблон на телефон
        if (true) {
            PatternString = "(....)(...)(....)"; //Разобьем на группы оставим как есть 1 и 3 части, а 2 часть заменим
        }
        PatternString = "\\w+@\\w+\\.\\w{2,3}"; // Шаблон на почтовый ящик

        // Надо
        String dataPattern = "<data>.*</data>";
        String phonePattern = "\\d+"; // Шаблон на телефон
        if (true) {
            String groupPattern = "(....)(...)(....)"; //Разобьем на группы оставим как есть 1 и 3 части, а 2 часть заменим
        }
        String emailPattern = "\\w+@\\w+\\.\\w{2,3}"; // Шаблон на почтовый ящик

        /* Создание класса без конструктора, а потом инициализация */
        
    }
}


