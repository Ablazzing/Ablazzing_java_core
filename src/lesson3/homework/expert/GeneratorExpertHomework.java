package lesson3.homework.expert;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GeneratorExpertHomework {
    private static final String LETTERS = "НМКУЕНХВАРОСМТ";
    private static final Random RANDOM = new Random(1);
    private static final int countRegions = 100;
    private static final int maxCountNumbers = 100;

    public static Map<Integer, Map<String, String[]>> getData() {
        Map<Integer, Map<String, String[]>> data = new HashMap<>();
        IntStream.range(0, countRegions).forEach((e) -> {
            int region = RANDOM.nextInt(1000);
            Map<String, String[]> regionStatistics = new HashMap<>();
            String[] numbersIn = generateCarNumbers();
            String[] numbersOut = generateCarNumbers();

            regionStatistics.put("input", numbersIn);
            regionStatistics.put("out", numbersOut);
            data.put(region, regionStatistics);
        });
        return data;
    }

    private static String generateRandomCarNumber() {
        String middleNumbers = String.valueOf(RANDOM.nextInt(1000));
        String region = String.valueOf(RANDOM.nextInt(1000));
        return new StringBuilder()
                .append(LETTERS.charAt(RANDOM.nextInt(LETTERS.length())))
                .append("0".repeat(3 - middleNumbers.length()))
                .append(middleNumbers)
                .append(LETTERS.charAt(RANDOM.nextInt(LETTERS.length())))
                .append(LETTERS.charAt(RANDOM.nextInt(LETTERS.length())))
                .append("0".repeat(3 - region.length()))
                .append(region)
                .toString();
    }

    private static String[] generateCarNumbers() {
        return Stream.generate(GeneratorExpertHomework::generateRandomCarNumber)
                .limit(RANDOM.nextInt(maxCountNumbers))
                .toArray(String[]::new);
    }
}
