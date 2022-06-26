package lesson5.expert;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

public class HomeworkExpert {
    private static final String DELIMITER = ";";

    public static void main(String[] args) throws IOException, URISyntaxException {
        //Экспертный уровень
        // Дано: папка, внутри которой находятся файлы, следующего именования - report_01_2012.txt, где 01 - месяц, 2012 - год
        // Внутри файла следующий формат:
        // pyterochka;122300.20;100312.10;20/01/2012
        // pyterochka;299922.00;323333.02;21/01/2012
        // perekrestok;9920.20;28200.01;21/01/2012
        // Где pyterochka - название магазина; 122300.20 - доход; 100312.10 - расход, 20/01/2012 - дата операции

        // Задача №1
        // Необходимо составить отчет о итоговой прибыли за каждый месяц по магазину pyterochka
        // Формат ожидаемого результата:
        // Прибыль по магазину pyterochka по месяцам
        // 01.2012: 20000.00
        // 02.2012: -100332.00
        // и тд

        DataGenerator.createReports();
        List<ShopRecord> shopRecords = readReports();
        String name = "pyterochka";
        printProfitByMonthAndShop(shopRecords, name);

        // Задача №2
        // Необходим составить отчет о расходах всех магазинов за весь период в разрезе по магазинам (т.е. прочитать все файлы внутри папки)
        // Формат ожидаемого результата:
        // Расходы pyterochka за весь период: 20032220.00
        // Расходы perekrestok за весь период: 1734220.00
        // .. и тд
        printOutcomesAllPeriodByShop(shopRecords);

    }

    public static void printOutcomesAllPeriodByShop(List<ShopRecord> shopRecords) {
        HashMap<String, Double> data = new HashMap<>();
        for (ShopRecord shopRecord : shopRecords) {
            Double totalOutcome = data.getOrDefault(shopRecord.getShop(), 0d);
            totalOutcome += shopRecord.getOutcome();
            data.put(shopRecord.getShop(), totalOutcome);
        }

        for (Map.Entry<String, Double> entry : data.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void printProfitByMonthAndShop(List<ShopRecord> shopRecords, String shopname) {
        if (shopRecords.size() == 0) {
            return;
        }

        ArrayList<ShopRecord> filteredShopRecords = new ArrayList<>();
        for (ShopRecord shopRecord : shopRecords) {
            if (shopRecord.getShop().equals(shopname)) {
                filteredShopRecords.add(shopRecord);
            }
        }

        filteredShopRecords.sort((first, second) -> first.getDate().compareTo(second.getDate()));
        Map<String, Double> data = new LinkedHashMap<>();
        for (ShopRecord filteredShopRecord : filteredShopRecords) {
            int month = filteredShopRecord.getDate().getMonthValue();
            int year = filteredShopRecord.getDate().getYear();
            String key = year + "_" + month;
            Double profit = data.getOrDefault(key, 0d);
            profit += filteredShopRecord.getIncome() - filteredShopRecord.getOutcome();
            data.put(key, profit);
        }

        for (Map.Entry<String, Double> entry : data.entrySet()) {
            String text = String.format("%s: %.2f", entry.getKey(), entry.getValue());
            System.out.println(text);
        }
    }

    public static List<ShopRecord> readReports() throws URISyntaxException, IOException {
        URI uri = HomeworkExpert.class.getClassLoader().getResource("").toURI();
        File folder = new File(uri);
        Pattern pattern = Pattern.compile("report.+[.]txt");
        List<ShopRecord> shopRecords = new ArrayList<>();
        for (File file : folder.listFiles()) {
            if (pattern.matcher(file.getName()).find()) {
                List<String> text = Files.readAllLines(file.toPath());
                for (int i = 1; i < text.size(); i++) {
                    String line = text.get(i);
                    ShopRecord shopRecord = parseTextReport(line);
                    shopRecords.add(shopRecord);
                }
            }
        }
        return shopRecords;
    }

    public static TreeMap<Integer, TreeMap<Integer, ShopMonthReport>> profitByMonthAndShop(
            List<ShopRecord> shopRecords,
            String shopname) {

        TreeMap<Integer, TreeMap<Integer, ShopMonthReport>> data = new TreeMap<>();
        for (ShopRecord record : shopRecords) {
            if (record.getShop().equals(shopname)) {
                int year = record.getDate().getYear();
                int month = record.getDate().getMonthValue();
                TreeMap<Integer, ShopMonthReport> monthData = data.getOrDefault(year, new TreeMap<>());
                ShopMonthReport report = monthData.getOrDefault(month,
                        new ShopMonthReport(record.getShop(), 0, 0, month, year));
                report.incrementIncome(record.getIncome());
                report.incrementOutcome(record.getOutcome());
                monthData.put(month, report);
                data.put(year, monthData);
            }
        }
        return data;
    }

    public static ShopRecord parseTextReport(String text) {
        try {
            String[] fields = text.split(DELIMITER);
            String shop = fields[0];
            double income = Double.parseDouble(fields[1]);
            double outcome = Double.parseDouble(fields[2]);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/y");
            LocalDate date = LocalDate.parse(fields[3], dateTimeFormatter);
            return new ShopRecord(shop, income, outcome, date);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
