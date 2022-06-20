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

    public static void createReports() throws IOException {
        Path resource = Paths.get("resource");
        if (!Files.exists(resource)) {
            Files.createDirectory(resource);
        }

        for (int i = 1; i < 13; i++) {
            int finalI = i;
            List<ReportRecord> reportRecords = Stream.generate(() -> generateRecord(finalI))
                    .limit(28)
                    .collect(Collectors.toList());
            createReportFile(i, Paths.get(resource.toString()), reportRecords);
        }
    }

    private static ReportRecord generateRecord(int month) {
        double income = RANDOM.doubles(1, 100000).findFirst().getAsDouble()
                + 10000.00;
        double outcome = RANDOM.doubles(1, 100000).findFirst().getAsDouble()
                + 10000.00;
        String shop = SHOPS[RANDOM.nextInt(4)];
        String date = new StringBuilder()
                .append(RANDOM.nextInt(28))
                .append("/")
                .append(month)
                .append("/2012")
                .toString();
        return new ReportRecord(shop, income, outcome, date);
    }

    private static void createReportFile(int month, Path destinationFolder, List<ReportRecord> reportRecords)
            throws IOException {
        String filename = new StringBuilder()
                .append("report_")
                .append(month < 10 ? "0" : "")
                .append(month)
                .append("_2012.txt")
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
