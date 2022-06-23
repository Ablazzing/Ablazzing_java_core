package homework3.lesson5expert;

import homework3.lesson5advanced.Lesson5Advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Lesson5Expert {
    public static String regex = "pyterochka;(\\d+\\.\\d{2});(\\d+\\.\\d{2});\\d{2}/(\\d)/\\d{4}";

    // Задача №1
    // Необходимо составить отчет о итоговой прибыли за каждый месяц по магазину pyterochka
    // Формат ожидаемого результат:
    // Прибыль по магазину pyterochka по месяцам
    // 01.2012: 20000.00
    // 02.2012: -100332.00
    // и тд
    public static void zadacha1expert() throws IOException {


        Stream<Path> resource = Files.list(Path.of("resource"));
        ???
        String filePath;
        getProfit(filePath, regex);


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Прибыль по магазину pyterochka по месяцам")
                .append(roundingUp(getProfit(filePath, regex)[1]) - roundingUp(getProfit(filePath, regex)[2]))
                .append(", общие расходы - ")
                .append(Lesson5Advanced.roundingUp(getProfit(filePath)[2]))
                .append("\n");

        System.out.println(outputString);

    }

    //метод округления даблов
    public static BigDecimal roundingUp(double number) {
        return new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
    }

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

//    public static String findMonth(String group3) {
//
//    }

    public static double getProfit(String filepath, String regex) throws IOException {
        FileReader fileReader = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

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

        double profit = incomeSum - outcomeSum;

        return profit;
    }


//    public static StringBuilder formMonthlyReport(String filename, int currentMonth, StringBuilder stringBuilder) throws IOException {
//        FileReader fileReader = new FileReader(filename);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String regex = "(\\d+\\.\\d{2});(\\d+\\.\\d{2});\\d{2}/(\\d)/\\d{4}";
//    }


}
