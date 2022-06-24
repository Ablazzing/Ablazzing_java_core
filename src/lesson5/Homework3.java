package lesson5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework3 {
    /**
     * Формат месяца для перебора коллекции
     */
    private final static List<String> mounts = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");

    public static void main(String[] args) throws IOException, ParseException {
        //Базовый уровень (для зачета нужно сделать хотя бы 2 из 3)
        //Задача №1
        //Дано: у нас есть две модели машин - жигули и toyota. Каждая из этих машин умеет: начинать движение,
        //останавливаться, включать фары. У жигули есть особенность: она ломается. У Toyota особенность: включает музыку
        //Необходимо:
        // 1.Создать абстрактный класс, который будет описывать общие действия этих машин (методы будут не абстрактные)
        // 2.Создать два класса, которые будут наследоваться от абстрактного класса, и реализовывать особенности этих машин
        // Методы должны просто печатать на экран действия машин (начал движение, включил музыку и тд.)

        //Задача №2
        //Необходимо:
        // 1. Создать папку resource, пометить ее как папку Resourсe root.
        // 2. Создать в ней файл "my_first_file.txt". На первой строке написать: "Моя бабушка", на второй: "читает газету жизнь"
        // 3. Прочитать файл, и вывести на экран все слова файла в одну строку
        // Ожидаемый результат: "Моя бабушка читает газету жизнь"

        //Задача №3
        //Необходимо:
        // 1. Создать класс Financial record, с двумя атрибутами: incomes, outcomes (доходы, расходы)
        // 2. Создать в этом классе геттеры, сеттеры и конструктор на все атрибуты
        // 3. Создать объект этого класса прямо здесь (class Homework3, метод main), с доходами 500, расходами 300
        // 4. Записать в файл "report.txt" данные из объекта класса.
        // Ожидаемый результат: в файле report.txt - одна строка: доходы = 500, расходы 300

        //Продвинутый уровень
        //Задача №1
        // Сделать задачу №1 из базовой.
        // 1. Создать класс CarFactory, у которого есть два статических методы: создать жигули, создать toyota.
        // 2. Создать 20 тойот, 20 жигулей с помощью CarFactory, положить их в один массив.
        // 3. Пройтись по массиву, проверить к какому классу принадлежит машина, привести тип к классу машины
        // и вызвать характерные для нее методы.

        //Задача №2
        // 1. Создать класс Financial record, с двумя атрибутами: incomes, outcomes (доходы, расходы)
        // 2. Создать в этом классе геттеры, сеттеры и конструктор на все атрибуты
        // 3. Создать 10 отчетов, с разными доходами и расходами (Смотри класс new Random(1).nextInt() )
        // 4. Записать в файл "report.txt" все данные из отчетов.
        // 5. Прочитать файл report.txt, просуммировать все доходы и вывести на экран, тоже самое с расходами
        // Ожидаемый результат: общие доходы - (какое то число), общие расходы - (какое то число)

        //Экспертный уровень
        // Дано: папка, внутри которой находятся файлы, следующего именования - report_01_2012.txt, где 01 - месяц, 2012 - год
        // Внутри файла следующий формат:
        // pyterochka;122300.20;100312.10;20/01/2012
        // pyterochka;299922.00;323333.02;21/01/2012
        // perekrestok;9920.20;28200.01;21/01/2012
        // Где pyterochka - название магазина; 122300.20 - доход; 100312.10 - расход, 20/01/2012 - дата операции

        // Задача №1
        // Необходимо составить отчет о итоговой прибыли за каждый месяц по магазину pyterochka
        // Формат ожидаемого результат:
        // Прибыль по магазину pyterochka по месяцам
        // 01.2012: 20000.00
        // 02.2012: -100332.00
        // и тд


        // Задача №2
        // Необходим составить отчет о расходах всех магазинов за весь период по магазинам (т.е. прочитать все файлы внутри папки)
        // Формат ожидаемого результат:
        // Расходы pyterochka за весь период: 20032220.00
        // Расходы perekrestok за весь период: 1734220.00
        // .. и тд


        HashMap<String, Double> finalProfitPyterochka = new HashMap<>();
        HashMap<String, Double> outcomeAllShop = new HashMap<>();

        final File folder = new File("resource");
        listFilesForFolder(folder, finalProfitPyterochka, outcomeAllShop);

        System.out.println("Прибыль по магазину pyterochka по месяцам");
        mounts.forEach(day -> System.out.println((day + "." + "2012:") + " " +
                String.format("%.2f", roundDouble(finalProfitPyterochka.get(day + "." + "2012"), 2))));

        System.out.println();
        for (Map.Entry<String, Double> stringMapEntry : outcomeAllShop.entrySet()) {
            System.out.print("Расходы  " + stringMapEntry.getKey() + "  за весь период: ");
            System.out.printf("%.2f%n", roundDouble(outcomeAllShop.get(stringMapEntry.getKey()), 2));
        }

    }


    /**
     * Заполнение мап с результатами
     */
    private static void getBufferedReader(String string, HashMap<String, Double> map, HashMap<String, Double> outcomeAllShop) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("resource/".concat(string)));
        while (bufferedReader.ready()) {
            String row = bufferedReader.readLine();
            List<String> collect = Arrays.asList(row.split(";"));
            outcomeCount(outcomeAllShop, collect);
            profitPyterochka(map, collect);
        }

    }

    /**
     * Доходы магазина пятерочка
     */
    private static void profitPyterochka(HashMap<String, Double> map, List<String> collect) throws ParseException {
        String shop = collect.get(0);
        if (shop.equals("pyterochka")) {
            String date = collect.get(3);
            double income = Double.parseDouble(collect.get(1));
            double outcome = Double.parseDouble(collect.get(2));
            String currentDate = getDate(date);

            if (map.containsKey(currentDate)) {
                map.put(currentDate, map.get(currentDate) + (income - outcome));
            } else {
                map.put(currentDate, (income - outcome));
            }
        }
    }

    /**
     * Получить дату в нужном формате
     */
    private static String getDate(String date) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(date)
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .format(DateTimeFormatter.ofPattern("MM.yyyy"));
    }

    /**
     * Расходы по всем магазинам
     */
    private static void outcomeCount(HashMap<String, Double> outcomeAllShop, List<String> collect) {
        String shop = collect.get(0);
        if (!shop.equals("магазин")) {
            double outcome = Double.parseDouble(collect.get(2));
            if (outcomeAllShop.containsKey(shop)) {
                outcomeAllShop.put(shop, outcomeAllShop.get(shop) + outcome);
            } else {
                outcomeAllShop.put(shop, outcome);
            }
        }

    }

    /**
     * Прочесть все файлы в папке
     */
    public static void listFilesForFolder(final File folder, HashMap<String, Double> map, HashMap<String, Double> outcomeAllShop) throws IOException, ParseException {
        for (final File fileEntry : folder.listFiles()) {

            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry, map, outcomeAllShop);
            } else {
                getBufferedReader(fileEntry.getName(), map, outcomeAllShop);
            }
        }
    }

    /**
     * Округлить значение до заданного знака после запятой
     *
     * @param value  число, которое нужно округлить
     * @param places порядок
     * @return округлённое число
     */
    public static double roundDouble(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
