package lesson1;

/**
 * Урок №1 - типы данных в java
 */
public class Lesson1 {
    public static void main(String[] args) {
        //Примитивы
        //Байт
        byte bt = 127;
        //Короткое число
        short sh = 32_000;
        //Целое число 32бит
        int num = 2_000_000_000;
        //Целое число 64бит
        long lon = 3_000_000_000_000_000_000L;

        int r = num + 2;
        int r2 = num - 2;
        int r3 = num * 2;
        int r4 = num / 2;

        //Числа с плавающей точкой
        float floa = 3.1112223334455f;
        //Число с плавающей точкой для большего количества разрядов
        double doub = 2.01231435345626;

        //Символы
        char ch = 123;
        char ch2 = 's';
        char ch3 = 'ы';

        //Что такое текст для компьютера?
        char[] textArray = new char[2];
        textArray[0] = ch;

        //Аналогия с поле чудес
        String fullText = String.valueOf(textArray);
        //Текст
        String text = "привет";

        //Конкатенация
        String word1 = "hello";
        String word2 = "world";
        String newWord = word1 + word2;

        //Работа со строками, рассказ про методы
        //Нижний регистр
        String s1 = word1.toLowerCase();
        //Верхний регистр
        String s2 = word1.toUpperCase();

        //Длина строки
        int length = word1.length();
        //Замена части строки на другую
        String s3 = word1.replaceAll("llo", "licopter");
        //Повторить строку n раз
        String s4 = word1.repeat(10);
        //Убрать лишние пробелы в начале и в конце строки
        String s5 = word1.trim();
    }
}
