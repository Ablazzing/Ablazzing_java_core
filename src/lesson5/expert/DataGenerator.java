package lesson5.expert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Класс генерирует отчеты в папке resource в текущем проекте (создает папку, если она не существует)
 */
public class DataGenerator {
    private static final Random RANDOM = new Random(1);
    private static final String[] SHOPS = {"pyterochka", "perekrestok", "ydoma", "okey"};
    private static final String REPORT_HEADER = "магазин;доход;расход;дата";
    private static final int COUNT_REPORTS = 12;
    private static final int COUNT_REPORT_RECORDS = 28;
    private static final int COUNT_DAYS = 28;
    private static final int MINIMUM_SUM_RECORD = 10000;
    private static final int MAXIMUM_SUM_RECORD = 100000;
    private static final int YEAR = 2012;

    public static void main(String[] args) throws IOException {
        System.out.println(DataGenerator.class.getClassLoader().getResource("report_01_2012.txt"));
        //createReports();
    }

    public static void createReports() throws IOException {
        Path resource = Paths.get("resource");
        if (!Files.exists(resource)) {
            Files.createDirectory(resource);
        }

        for (int i = 1; i < COUNT_REPORTS + 1; i++) {
            int finalI = i;
            List<ReportRecord> reportRecords = Stream.generate(() -> generateRecord(finalI))
                    .limit(COUNT_REPORT_RECORDS)
                    .collect(Collectors.toList());
            createReportFile(i, Paths.get(resource.toString()), reportRecords);
        }
    }

    private static ReportRecord generateRecord(int month) {
        double income = RANDOM.doubles(MINIMUM_SUM_RECORD, MAXIMUM_SUM_RECORD).findFirst().getAsDouble();
        double outcome = RANDOM.doubles(MINIMUM_SUM_RECORD, MAXIMUM_SUM_RECORD).findFirst().getAsDouble();
        String shop = SHOPS[RANDOM.nextInt(SHOPS.length)];
        String date = new StringBuilder()
                .append(RANDOM.nextInt(COUNT_DAYS) + 1)
                .append("/")
                .append(month)
                .append("/")
                .append(YEAR)
                .toString();
        return new ReportRecord(shop, income, outcome, date);
    }

    private static void createReportFile(int month, Path destinationFolder, List<ReportRecord> reportRecords)
            throws IOException {
        String filename = new StringBuilder()
                .append("report_")
                .append(month < 10 ? "0" : "")
                .append(month)
                .append("_")
                .append(YEAR)
                .append(".txt")
                .toString();

        String filePath = Paths.get(destinationFolder.toString(), filename).toString();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(REPORT_HEADER);
            bufferedWriter.newLine();
            reportRecords.forEach(record -> {
                try {
                    bufferedWriter.write(record.toString());
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
