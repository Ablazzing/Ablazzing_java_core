package lesson3.homeWork2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Домашняя работа 2.1
 */
public class HomeWorkExpert1 {

    public void resultHomeWork(Map<Integer, Map<String, String[]>> data) {
        Map<Integer, Map<String, Integer>> result = new HashMap<>();
        Map<Integer, Integer> countCarInputRegion = new HashMap<>();

        data.forEach((region, cars) -> {
            Map<String, Integer> countCar = new HashMap<>();
            Map<String, Integer> regionResultCars = new HashMap<>();

            fillCountCarMap(cars, countCar);
            fillPopularRegion(countCar, regionResultCars);

            result.put(region, regionResultCars);
            countCarInputRegion.put(region, countCar.values().stream().reduce(0, Integer::sum));
        });

        LinkedHashMap<Integer, Integer> topRegions = countCarInputRegion.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        Set<Integer> integers = topRegions.keySet();
        String join = String.join(", ", integers.toString());

        System.out.println("ТОП-5: " + join.substring(1, join.length() - 1));

        topRegions.forEach((region, total) -> {
            LinkedHashMap<String, Integer> carRegionAndCountInput = result.get(region).entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(1)
                    .collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            String regionCar = carRegionAndCountInput.keySet().toString();
            String countInput = carRegionAndCountInput.values().toString();
            System.out.println(region.toString().concat(" - больше всего въехало с номерами ")
                    .concat(regionCar.substring(1, regionCar.length() - 1))
                    .concat(": ")
                    .concat(countInput.substring(1, countInput.length() - 1))
                    .concat(" машины"));
        });
    }

    /**
     * Наполнить мапу ключ - регион, значение - количество въехавших машин суммарно
     */
    private void fillPopularRegion(Map<String, Integer> countCar, Map<String, Integer> regionResultCars) {
        countCar.forEach((number, count) -> {
            if (count > 0) {
                String carRegion = Arrays.asList(number.split("\\W\\d{3}\\W{2}")).get(1);
                if (!regionResultCars.containsKey(carRegion)) {
                    regionResultCars.put(carRegion, count);
                } else {
                    regionResultCars.put(carRegion, regionResultCars.get(carRegion) + count);
                }
            }
        });
    }

    /**
     * Наполнить мапу номерами машин, чтобы получить точное количество въехавших машин в регион
     */
    private void fillCountCarMap(Map<String, String[]> cars, Map<String, Integer> countCar) {
        String[] carsNumberInput = cars.get("input");
        List<String> carNumbersList = Arrays.asList(carsNumberInput);
        carNumbersList.forEach(number -> {
            if (!countCar.containsKey(number)) {
                countCar.put(number, 1);
            } else {
                countCar.put(number, (countCar.get(number) + 1));
            }
        });

        String[] carsNumberOutput = cars.get("out");
        carNumbersList = Arrays.asList(carsNumberOutput);
        carNumbersList.forEach(number -> {
            if (countCar.containsKey(number)) {
                countCar.put(number, (countCar.get(number) - 1));
            }
        });
    }
}
