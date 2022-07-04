package homework3.lesson5expert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Lesson5Expert {

    public static String dataLineRegex = "(\\p{L}+)\\;(\\d+\\.\\d{2})\\;(\\d+\\.\\d{2})\\;\\d+/\\d+/\\d{4}";
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

        List<File> wantedFiles = findWantedFiles(files, "2012");
        StringBuilder stringBuilder = new StringBuilder();
        String storeName = "pyterochka";
        stringBuilder.append("Прибыль по магазину ").append(storeName).append(" по месяцам\n");
        formMonthlyReport(wantedFiles, stringBuilder, storeName);
    }

    public static void zadacha2expert() throws IOException {
        List<File> wantedFiles = findWantedFiles(files, "2012");
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> stores = new HashSet<>();
        for (File file :
                wantedFiles) {
            stores.addAll(findStores(file));
        }
        for (String storeName :
                stores) {
            stringBuilder.append("Расходы ").append(storeName).append(" за весь период: ");
            formReport(wantedFiles, stringBuilder, storeName);
        }
        System.out.println(stringBuilder);
    }

    //формируем отчет
    private static void formReport(List<File> wantedFiles, StringBuilder stringBuilder, String storeName) throws IOException {
        double allOutcomes = 0;
        for (File file :
                wantedFiles) {
            BigDecimal allOutcomesForMonth = findAllOutcomesForMonth(file, dataLineRegex, storeName);
            allOutcomes += allOutcomesForMonth.doubleValue();
        }
        stringBuilder
                .append(roundingUp(allOutcomes))
                .append("\n");
    }

    //ищем уникальные имена магазинов проходя по всем файлам
    private static Set<String> findStores(File file) throws IOException {
        Set<String> stores = new HashSet<>();
        BufferedReader bufferedReader = fileReader(file);
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            if (!line.contains("магазин")) {
                String[] splittedLine = line.split(";");
                String storename = splittedLine[0];
                stores.add(storename);
            }
        }
        return stores;
    }
    //создаем долбанный ридер
    private static BufferedReader fileReader(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        return new BufferedReader(fileReader);
    }

    //формируем ежемесячный отчет
    private static void formMonthlyReport(List<File> wantedFiles, StringBuilder stringBuilder, String storeName) throws IOException {
        for (File file :
                wantedFiles) {
            String date = findPeriod(file.toString(), fileNameRegex);
            BigDecimal profit = getProfit(file, dataLineRegex, storeName);
            stringBuilder
                    .append(date)
                    .append(": ")
                    .append(profit)
                    .append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    //ищем нужные файлы по запросу если в папке дохера всяких файлов
    private static List<File> findWantedFiles(File[] files, String requestString) {
        return Arrays.stream(files)
                .filter(file -> file.getName().contains(requestString))
                .collect(Collectors.toList());
    }

    //находим сумму расходов
    public static BigDecimal findAllOutcomesForMonth(File file, String dataLineRegex, String storeName) throws IOException {
        double outcomeSum = 0.0;
        BufferedReader bufferedReader = fileReader(file);
        while (bufferedReader.ready()) {
            String dataLine = bufferedReader.readLine();
            if (dataLine.contains(storeName)) {
                String[] values = findValues(dataLine, dataLineRegex);
                for (int i = 0; i < values.length; i++) {
                    if (i == 1) {
                        outcomeSum += Double.parseDouble(values[i]);
                    }
                }
            }
        }
        return roundingUp(outcomeSum);
    }

    //подхватываем месяц из имени файла
    private static String findPeriod(String fileName, String fileNameRegex) {
        Matcher matcher = Pattern.compile(fileNameRegex).matcher(fileName);
        String[] dateParts = new String[2];
        for (int i = 0; i < dateParts.length; i++) {
            if (matcher.find()) {
                dateParts[0] = matcher.group(1);
                dateParts[1] = matcher.group(2);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(dateParts[0])
                .append(".")
                .append(dateParts[1]);
        return stringBuilder.toString();
    }

    //метод округления даблов
    private static BigDecimal roundingUp(double number) {
        return new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
    }

    //метод поиска числовых значений в строке по regex
    private static String[] findValues(String inputLine, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(inputLine);
        String[] values = new String[2];
        if (matcher.find()) {
            values[0] = matcher.group(2);
            values[1] = matcher.group(3);
        }
        return values;
    }

    //получаем прибыль за период
    private static BigDecimal getProfit(File file, String dataLineRegex, String storeName) throws
            IOException {
        double incomeSum = 0.0;
        double outcomeSum = 0.0;
        BufferedReader bufferedReader = fileReader(file);

        while (bufferedReader.ready()) {
            String dataLine = bufferedReader.readLine();
            if (dataLine.contains(storeName)) {
                String[] values = findValues(dataLine, dataLineRegex);
                for (int i = 0; i < values.length; i++) {
                    if (i == 0) {
                        incomeSum += Double.parseDouble(values[i]);
                    } else if (i == 1) {
                        outcomeSum += Double.parseDouble(values[i]);
                    }
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
