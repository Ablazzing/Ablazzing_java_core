package lesson1;


import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class MyHomework1 {

    //Задача №1
    //Создать из трех переменных единую строку,
    //Привести к правильному виду (Ниже)
    //затроить (Можно вызвать тольку одну команду System.out.print())
    //Результат вывода на экран:
    //Hello world!
    //Hello world!
    //Hello world!
    private static String resultString(String str1, String str2, char ch){
        String res = str1.trim() + str2.toLowerCase() + ch;
        return res + res + res;
    }

    //Задача №2
    //Создать переменные с ростом, весом.
    //Произвести расчет индекса массы тела (вес) / (рост * рост) используя переменные, вывести на экран
    //Пример результата вывода на экран:
    //21.0
    private static double bodyMassIndex(int weight, double height) {
        return weight / height / height;
    }

    //Задача №3
    //Создать из массива букв a,b,c,d,e, строку,вывести на экран , поменять в массиве 4 букву по счету на h,
    //и снова создать строку, вывести на экран
    private static void resString(char[] chars){
        String str = String.valueOf(chars);
        System.out.println(str);
        chars[3] = 'h';
        str = String.valueOf(chars);
        System.out.println(str);
    }

    //Продвинутый уровень
    //Задача №1
    //Произвести преобразование "234" в число типа int и прибавить к этому числу длину строки "some_text"
    private static int intPlusStrLen(){
        return Integer.parseInt("234") + "some_text".length();
    }

    //Задача №2
    //Посчитать (a+b)^2 = ?, при a=3, b=5
    private static double quadraticEquation(){
        return Math.pow((3 + 5), 2);
    }

    //Задача №3
    //Создать два массив чисел:
    // 1,2,5,7,10
    // 2,3,2,17,15
    // Создать массив чисел, в котором будут: все числа из этих двух массивов,
    // и результат умножения чисел с одинаковым порядковым номером
    //
    //Ожидаемый результат:
    //1,2,5,7,10,2,3,2,17,15,2,6,10,119,150
    //(первый массив - 1,2,5,7,10), (второй массив - 2,3,2,17,15),
    //(результат перемножения - (1*2), (2*3), (5*2), (7*17), (10*15)
    private static int[] arrayMultiplier(){
        int[] arr1 = {1,2,5,7,10};
        int[] arr2 = {2,3,2,17,15};
        int[] multArr = new int[arr2.length];
        Arrays.setAll(multArr, i -> arr1[i] * arr2[i]);
        int[] concatArr = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray();
        return IntStream.concat(Arrays.stream(concatArr), Arrays.stream(multArr)).toArray();
    }

    //Задача №4
    //В слове "Hello world!" заменить все l на r, сделать все буквы заглавными, выбрать первые 8 символов
    private static String strReplace(){
        return "Hello world!".replace('l', 'r').toUpperCase().substring(0, 8);
    }

    //Экспертный уровень
    //Задача №1
    //Создать метод маскирования персональных данных, который:
    //Телефон (до/после маскирования): 79991113344 / 7999***3344
    //Email (до/после маскирования): test@yandex.ru / tes*@******.ru, my_mail@gmail.com / my_mai*@*****.com
    //Фио (до/после маскирования): Иванов Иван Иванович / И****в Иван И.
    //
    //Входящие параметры: String text
    //Возвращаемый результат: String
    //
    //Примеры возможного текста:
    //<client>(Какие то данные)<data>79991113344;test@yandex.ru;Иванов Иван Иванович</data></client> - "<client>(Какие то данные)<data>7999***3344;tes*@******.ru;И****в Иван И.</data></client>"
    //<client>(Какие то данные)<data></data></client> - вернет тоже (никаких ошибок)
    //<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344</data></client> - "<client>(Какие то данные)<data>И****в Иван И.;7999***3344</data></client>"
    //Используемые технологии: String.find, String.replaceAll, String.split, String.join, String.contains, String.substring
    //Регулярные выражения, класс StringBuilder
//    public static String masking(String str){
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(str);
//        return resStr();
//    }

    public static void main(String[] args) {

        //Задача №1
        System.out.println("Задача №1. Базовый уровень.");
        String hi = "                Hello ";
        String world = " WoRld!";
        char newLine = '\n';
        System.out.println(resultString(hi, world, newLine));

        //Задача №2
        System.out.println("Задача №2. Базовый уровень.");
        int weight = 75;
        double height = 1.75;
        System.out.println(bodyMassIndex(weight, height));
        System.out.println();

        //Задача №3
        System.out.println("Задача №3. Базовый уровень.");
        char[] strArray = {'a', 'b', 'c', 'd', 'e'};
        resString(strArray);
        System.out.println();

        //Продвинутый уровень
        //Задача №1
        System.out.println("Задача №1. Продвинутый уровень.");
        System.out.println(intPlusStrLen());
        System.out.println();

        //Задача №2
        System.out.println("Задача №2. Продвинутый уровень.");
        System.out.println(quadraticEquation());
        System.out.println();

        //Задача №3
        System.out.println("Задача №3. Продвинутый уровень.");
        System.out.println(Arrays.toString(arrayMultiplier()));
        System.out.println();

        //Задача №4
        System.out.println("Задача №4. Продвинутый уровень.");
        System.out.println(strReplace());
        System.out.println();
        //В слове "Hello world!" заменить все l на r, сделать все буквы заглавными, выбрать первые 8 символов

        //Экспертный уровень
        //Задача №1
        System.out.println("Задача №1. Экспертный уровень.");
        String str1 = "<client>(Какие то данные)<data>79991113344;test@yandex.ru;Иванов Иван Иванович</data></client>";
        String str2 = "<client>(Какие то данные)<data></data></client>";
        String str3 = "<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344</data></client>";

    }

}
