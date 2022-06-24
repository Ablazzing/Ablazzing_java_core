package homework3.lesson5expert;

import lesson5.Homework3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Lesson5Expert {
    public static String dataLineRegex = "pyterochka;(\\d+\\.\\d{2});(\\d+\\.\\d{2});\\d{2}/(\\d)/\\d{4}";
    public static String fileNameRegex = "\\p{L}+\\_(\\d{2})\\_(\\d{4}).\\p{L}+";
    public static File[] files = new File("resource").listFiles();


    // Задача №1
    // Необходимо составить отчет о итоговой прибыли за каждый месяц по магазину pyterochka
    // Формат ожидаемого результат:
    // Прибыль по магазину pyterochka по месяцам
    // 01.2012: 20000.00
    // 02.2012: -100332.00
    // и тд
    public static void zadacha1expert() throws IOException {

        System.out.println(Arrays.toString(files));
        List<String> wantedFiles = Arrays.stream(files)
                .map(File::getName)
                .filter(name -> name.contains("2012"))
                .collect(Collectors.toList());
        System.out.println(wantedFiles);


//        System.out.println(resource);

//
//        ???
//        getFileName();
//        getProfit(fileName, dataLine);
//
//
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Прибыль по магазину pyterochka по месяцам")
//                .append(getDate(fileName, dataLine))
//                .append(getProfit(fileName, dataLine))
//                .append(", общие расходы - ")
//                .append("\n");
//
//        System.out.println();

    }

    public static String getFileNameByMonth(Integer month) {
            if (month < 10) {
                String s = Homework3.class.getClassLoader().getResource("report_0" + month + "_2012.txt").toString();
                return s;
            } else if (month < 12) {

                String s = Homework3.class.getClassLoader().getResource("report_" + month + "_2012.txt").toString();
                return s;
            } else {
                System.out.println("Введите корректный номер месяца");
                return null;
            }
    }

    private static String getDate(String fileName, String fileNameRegex) {
        Matcher matcher = Pattern.compile(fileNameRegex).matcher(fileName);
        String[] dateParts = new String[2];
        for (int i = 0; i < dateParts.length; i++) {
            if (matcher.find()) {
                dateParts[0] = matcher.group(1);
                dateParts[1] = matcher.group(2);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dateParts[0]).append(dateParts[1]);

        return stringBuilder.toString();
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

    public static BigDecimal getProfit(String fileName, String regex) throws IOException {
        FileReader fileReader = new FileReader(fileName);
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


        return roundingUp(profit);
    }


//    public static StringBuilder formMonthlyReport(String filename, int currentMonth, StringBuilder stringBuilder) throws IOException {
//        FileReader fileReader = new FileReader(filename);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String regex = "(\\d+\\.\\d{2});(\\d+\\.\\d{2});\\d{2}/(\\d)/\\d{4}";
//    }


}
