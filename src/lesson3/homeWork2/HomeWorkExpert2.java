package lesson3.homeWork2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Домашнее работа 2.2
 */
public class HomeWorkExpert2 {

    public void countCarSpecialNumber(Map<Integer, Map<String, String[]>> data) {
        Set<String> carNumbers = new HashSet<>();
        data.forEach((region, cars) -> {
            cars.forEach((rey, value) -> carNumbers.addAll(Arrays.stream(value).collect(Collectors.toSet())));
        });

        AtomicInteger result = new AtomicInteger();
        carNumbers.forEach(number -> {
            String s = number.replaceAll("\\d", "");
            if (s.equals("МАВ")) {
                result.set(result.get() + 1);
            }
        });
        System.out.println("Машин со спец номерами M AB: " + result);
    }
}
