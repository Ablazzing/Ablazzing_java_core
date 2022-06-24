package homework2.lesson3expert;

import lesson3.homework.expert.GeneratorExpertHomework;

import java.util.*;
import java.util.stream.Collectors;

public class Lesson3Expert {
    // Экспертный уровень:
    // Предыстория: Мы находимся в статистическом институте. Хочется понять уровень миграции между регионами за месяц.
    // Для этого было решено произвести анализ передвижения автомобилей: на границе каждого региона стоят камеры,
    // фиксирующие въезд и выезд автомобилей. Формат автомобильного номера: (буква)(3 цифры)(2 буквы)(2-3 цифры)
    // К474СЕ178 - где 178 регион

    // Задача №1: составить топ-5 популярных регионов (куда больше всего въехали).
    // Сделать аналитическую раскладку: машины какого региона больше всего въезжали в этот топ-5.
    // Ожидаемый результат:
    // ТОП-5: 98, 178, 01, 22, 33
    // 98 - больше всего въехало с номерами 178: 23 машины
    // 178 - больше всего въехало с номера 98: 50 машин
    // 01 - больше всего въехало с номера 178: 11 машин
    // 22 - больше всего въехало с номера 01: 30 машин
    // 33 - больше всего въехало с номера 12: 100 машин

    // Задача №2: узнать сколько всего машин со спец номерами: начинаются на M и заканчиваются на АВ.
    // Не повторяющиеся

    //Входящие данные
    // Map<Integer, Map<String, String[]>> - где ключ первого уровня - номер региона,
    // out, input - ключи второго уровня (выезд, въезд), и String[] - массивы номеров.
    // { 1 : {
    //      "out" : ["К474СЕ178"],
    //      "input": ["А222РТ178"]
    //    },
    //   2 : {
    //        "out" : ["К722АВ12", "А222РТ178"],
    //        "input" : ["М001АВ01", "А023РВ73"],
    //   }
    // ..
    //  }

    //Список технологий:
    // Set (HashSet) - узнать что это, set.contains(), set.put()
    // Map (HashMap) - узнать что это, map.get(), map.put(), map.entrySet() - для итерации, entry.getValue(), entry.getKey()
    // <Integer> - обозначает тип который хранится в этой структуре данных (Generics)
    // Регулярные выражения - вытащить регион авто


    public static void main(String[] args) {

        Map<Integer, Map<String, String[]>> dataMap = GeneratorExpertHomework.getData();
        Map<Integer, Integer> carsNumberPerHomeRegion = new TreeMap<>();
        Set<Integer> incomingCarsQuantity = new TreeSet<>();
        Set<String> specNumbers = new HashSet<>();
        int[] top5ImmigrationRegions = new int[5];
        Map<Integer, String[]> carsForeignRegions = new HashMap<>();

        dataMap.forEach((homeRegion, registrationNumberMap) -> {
            String[] incomingRegistrationNumbers = registrationNumberMap.get("input");
            String[] outgoingRegistrationNumbers = registrationNumberMap.get("out");

            String[] foreignRegions = new String[incomingRegistrationNumbers.length];
            incomingCarsQuantity.add(incomingRegistrationNumbers.length);
            carsNumberPerHomeRegion.put(homeRegion, incomingRegistrationNumbers.length);//

            for (int i = 0; i < incomingRegistrationNumbers.length; i++) {
                String incomingRegNumber = incomingRegistrationNumbers[i];

                if (incomingRegNumber.length() > 8) {
                    String region = incomingRegNumber.substring(incomingRegNumber.length() - 3);
                    foreignRegions[i] = region;
                } else if (incomingRegNumber.length() == 8) {
                    String region = incomingRegNumber.substring(incomingRegNumber.length() - 2);
                    foreignRegions[i] = region;
                }

                boolean isSpecNumberIn =
                        incomingRegNumber.charAt(0) == 'М'
                                && incomingRegNumber.charAt(4) == 'А'
                                && incomingRegNumber.charAt(5) == 'В';

                if (isSpecNumberIn) {
                    specNumbers.add(incomingRegNumber);
                }
            }
            for (String outgoingRegNumber : outgoingRegistrationNumbers) {
                boolean isSpecNumberOut =
                        outgoingRegNumber.charAt(0) == 'М'
                                && outgoingRegNumber.charAt(4) == 'А'
                                && outgoingRegNumber.charAt(5) == 'В';
                if (isSpecNumberOut) {
                    specNumbers.add(outgoingRegNumber);
                }
            }
            carsForeignRegions.put(homeRegion, foreignRegions);
        });

        for (int i = incomingCarsQuantity.size() - 1, count = 0; count < 5; i--, count++) {
            int finalI = i;
            top5ImmigrationRegions[count] = carsNumberPerHomeRegion.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(incomingCarsQuantity.toArray()[finalI]))
                    .findAny()
                    .get()
                    .getKey();
        }

        StringBuilder sb = new StringBuilder();
        for (int top5ImmigrationRegion : top5ImmigrationRegions) {
            sb.append(top5ImmigrationRegion).append(", ");
        }
        System.out.println("ТОП-5: " + sb.substring(0, sb.length() -2));

        Map<String, Integer> foreignRegionsDuplicates;
        for (int region :
                top5ImmigrationRegions) {
            foreignRegionsDuplicates = new HashMap<>();
            for (int i = 0; i < carsForeignRegions.get(region).length; i++) {
                String foreignRegion = carsForeignRegions.get(region)[i];
                foreignRegionsDuplicates
                        .put(foreignRegion, foreignRegionsDuplicates.getOrDefault(foreignRegion, 0) + 1);
            }

//            String carRegion = foreignRegionsDuplicates.entrySet().stream()
//                    .max(Map.Entry.comparingByValue()).get().getKey().toString();
//            System.out.println(carRegion);

            Integer maxCarsEnteredWithSameCarRegion = foreignRegionsDuplicates.entrySet().stream()
                    .max(Map.Entry.comparingByValue()).get().getValue();

            StringBuilder outputData = new StringBuilder();
            for (Map.Entry<String, Integer> entry : foreignRegionsDuplicates.entrySet()) {
                if (entry.getValue().equals(maxCarsEnteredWithSameCarRegion)) {
                    outputData.append(entry.getKey()).append(", ");
                }
            }
            System.out.println(
                            region
                            + " - больше всего въехало с номерами "
                            + outputData.substring(0, outputData.length() - 2)
                            + ": "
                            + maxCarsEnteredWithSameCarRegion
                            + " машин(ы)"
            );
        }
        System.out.println("Всего машин со спецномерами - " + specNumbers.size());


    }

}
