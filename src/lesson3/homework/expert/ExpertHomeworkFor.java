package lesson3.homework.expert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static lesson3.homework.expert.GeneratorExpertHomework.getData;

public class ExpertHomeworkFor {

    public static void main(String[] args) {
        Map<Integer, Map<String, String[]>> data = getData();
        getTopFiveInputRegions(data);
        getSpecialNumbers(data);
    }

    public static void getTopFiveInputRegions(Map<Integer, Map<String, String[]>> data) {
        ArrayList<RegionStatistic> list = new ArrayList<>();

        //Начинаю перебирать все регионы
        for (Map.Entry<Integer, Map<String, String[]>> entry : data.entrySet()) {
            Integer region = entry.getKey();
            int carsInputCount = entry.getValue().get("input").length;
            //если в регион не въезжали машины, пропускаем его
            if (carsInputCount == 0) {
                 continue;
            }

            //Статистика: регионы въезжающих машин - количество
            LinkedHashMap<Integer, Long> stat = new LinkedHashMap<>();
            //Максимальное количество машин из одного региона
            long maxPopularCarRegionCount = 0;
            for (String carNumber : entry.getValue().get("input")) {
                Integer carRegion = Integer.parseInt(carNumber.substring(carNumber.length() - 3));
                long countCarRegion = stat.getOrDefault(carRegion, 0l) + 1;
                stat.put(carRegion, countCarRegion);
                if (maxPopularCarRegionCount < countCarRegion) {
                    maxPopularCarRegionCount = countCarRegion;
                }
            }

            //Машин из какого региона приехало больше всего
            int maxPopularCarRegion = 0;
            for (Map.Entry<Integer, Long> carInputRegionStat : stat.entrySet()) {
                if (carInputRegionStat.getValue().equals(maxPopularCarRegionCount)) {
                    maxPopularCarRegion = carInputRegionStat.getKey();
                }
            }

            //Создаем запись, хранящую всю информацию о регионе
            RegionStatistic popularRegion = new RegionStatistic(region, carsInputCount, maxPopularCarRegion,
                    maxPopularCarRegionCount);
            list.add(popularRegion);
        }

        //Сортируем в обратном порядке(* -1) от региона где больше всего въехало машин, к самому непопулярному
        list.sort((a, b) -> Integer.compare(a.getCountInputCars(), b.getCountInputCars()) * -1);
        for (RegionStatistic regionStatistic : list.subList(0, 5)) {
            System.out.println(regionStatistic);
        }
    }

    public static void getSpecialNumbers(Map<Integer, Map<String, String[]>> data) {
        Pattern pattern = Pattern.compile("М\\d{3}АВ");
        HashSet<String> specialNumbers = new HashSet<>();
        for (Map.Entry<Integer, Map<String, String[]>> entry : data.entrySet()) {
            for (Map.Entry<String, String[]> regionData : entry.getValue().entrySet()) {
                for (String carNumber : regionData.getValue()) {
                    if (pattern.matcher(carNumber).find()) {
                        specialNumbers.add(carNumber);
                    }
                }
            }
        }
        System.out.println(specialNumbers);
    }
}
