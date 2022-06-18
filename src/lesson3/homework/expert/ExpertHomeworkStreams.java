package lesson3.homework.expert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lesson4.GeneratorExpertHomework.getData;

public class ExpertHomeworkStreams {

    public static void main(String[] args) {
        Map<Integer, Map<String, String[]>> data = getData();
        getTopFiveInputRegions(data);
        getSpecialNumbers(data);
        ExpertHomeworkFor.getTopFiveInputRegions(data);

    }

    public static void getTopFiveInputRegions(Map<Integer, Map<String, String[]>> data) {
        data.entrySet().stream()
                .filter(statistic -> statistic.getValue().get("input").length > 0)
                .map(entry -> {
                    int region = entry.getKey();
                    int countInputCars = entry.getValue().get("input").length;
                    Map.Entry<Integer, Long> popularCar = Arrays.stream(entry.getValue().get("input"))
                            .map(carNumber -> Integer.parseInt(carNumber.substring(carNumber.length() - 3)))
                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                            .entrySet()
                            .stream()
                            .sorted((a, b) -> Long.compare(a.getValue(), b.getValue()) * -1)
                            .findFirst()
                            .get();
                    return new RegionStatistic(region,countInputCars, popularCar.getKey(), popularCar.getValue());})
                .sorted(Comparator.comparingInt(RegionStatistic::getCountInputCars).reversed())
                .limit(5)
                .forEach(System.out::println);
    }

    public static void getSpecialNumbers(Map<Integer, Map<String, String[]>> data) {
        Pattern pattern = Pattern.compile("М\\d{3}АВ");
        data.forEach((key, value) -> value.entrySet().stream()
                .flatMap(regionStatistics -> Arrays.stream(regionStatistics.getValue()))
                .filter(carNumber -> pattern.matcher(carNumber).find())
                .distinct()
                .forEach(System.out::println));
    }
}
