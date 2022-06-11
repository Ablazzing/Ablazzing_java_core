package lesson1;

public class HomeworkBaseErrors {
    public static void main(String[] args) {
        /* Не использование repeat, а вручную копирование строк */
        String hi = "hello";
        String world = " world!";
        String newLine = "\n";
        String phrase = hi + world + newLine;
        //Вместо
        String resultWrong = phrase + phrase + phrase;

        //Надо
        String result = phrase.repeat(3);

        /* Перепутали индексы, отсчет идет от нуля! */
        // Вместо
        int[] numbers = new int[5];
        numbers[4] = 4;
        // Надо
        numbers[3] = 4;
    }
}
