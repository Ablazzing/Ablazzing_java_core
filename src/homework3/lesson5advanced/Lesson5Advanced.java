package homework3.lesson5advanced;

import homework3.lesson5basic.Car;
import homework3.lesson5basic.FinancialRecord;
import homework3.lesson5basic.Lada;
import homework3.lesson5basic.Toyota;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.PrivateKey;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson5Advanced {
    //Продвинутый уровень
    //Задача №1
    // Сделать задачу №1 из базовой.
    // 1. Создать класс CarFactory, у которого есть два статических методы: создать жигули, создать toyota.
    // 2. Создать 20 тойот, 20 жигулей с помощью CarFactory, положить их в один массив.
    // 3. Пройтись по массиву, проверить к какому классу принадлежит машина, привести тип к классу машины
    // и вызвать характерные для нее методы.

    public static void zadacha1advanced() {
        Car[] cars = new Car[40];

        for (int i = 0; i < cars.length; i++) {
            if (i <= 19) {
                cars[i] = CarFactory.makeLada();
            }
            if (i > 20) {
                cars[i] = CarFactory.makeToyota();
            }
        }

        for (Car car :
                cars) {
            if (car instanceof Lada) {
                Lada newLada = (Lada) car;
                newLada.canBreak();

            }
            if (car instanceof Toyota) {

                Toyota newToyota = (Toyota) car;
                newToyota.canPlayMusic();
            }
        }
    }

    //Задача №2
    // 1. Создать класс Financial record, с двумя атрибутами: incomes, outcomes (доходы, расходы)
    // 2. Создать в этом классе геттеры, сеттеры и конструктор на все атрибуты
    // 3. Создать 10 отчетов, с разными доходами и расходами (Смотри класс new Random(1).nextInt() )
    // 4. Записать в файл "report.txt" все данные из отчетов.
    // 5. Прочитать файл report.txt, просуммировать все доходы и вывести на экран, тоже самое с расходами
    // Ожидаемый результат: общие доходы - (какое то число), общие расходы - (какое то число)

    private static final String FILEPATH = "resource/report.txt";

    public static void zadacha2advanced() throws IOException {
        fulfillFile(FILEPATH);
        System.out.println(getIncomeAndOutcomeSums(FILEPATH));
    }

    //метод поиска числовых значений в строке по паттерну
    public static String[] findValues(String inputLine, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(inputLine);
        String[] values = new String[2];
        for (int i = 0; i < values.length; i++) {
            if (matcher.find()) {
                values[0] = matcher.group(1);
                values[1] = matcher.group(2);
            }
        }
        return values;
    }

    //метод заполнения файла случайными числами
    public static void fulfillFile(String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        Random random = new Random(1);
        double rangeMin = 0.0;
        double rangeMax = 1000000.0;

        for (int i = 1; i <= 10; i++) {
            double randomValue1 = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
            double randomValue2 = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
            FinancialRecord financialRecord = new FinancialRecord(randomValue1, randomValue2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("доходы = ")
                    .append(roundingUp(financialRecord.getIncomes()))
                    .append(", расходы = ")
                    .append(roundingUp(financialRecord.getOutcomes()))
                    .append("\n");
            fileWriter.write(stringBuilder.toString());
        }
        fileWriter.close();
    }

    //метод округления даблов
    public static BigDecimal roundingUp(double number) {
        return new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
    }

    //метод высчитывания сумм доходов и расходов полученных из файла
    public static String getIncomeAndOutcomeSums(String filepath) throws IOException {
        FileReader fileReader = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String regex = "\\p{L}+\\s=\\s(\\d{1,7}\\.\\d{2}),\\s\\p{L}+\\s=\\s(\\d{1,7}\\.\\d{2})";

        double incomeSum = 0.0;
        double outcomeSum = 0.0;

        while (bufferedReader.ready()) {
            String documentLine = bufferedReader.readLine();
            String[] values = findValues(documentLine, regex);

            for (int i = 0; i < values.length; i++) {
                if (i == 0) {
                    incomeSum += Double.parseDouble(values[i]);
                } else if (i == 1) {
                    outcomeSum += Double.parseDouble(values[i]);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("общие доходы -")
                .append(roundingUp(incomeSum))
                .append(", общие расходы - ")
                .append(roundingUp(outcomeSum))
                .append("\n");

        return stringBuilder.toString();
    }
}
