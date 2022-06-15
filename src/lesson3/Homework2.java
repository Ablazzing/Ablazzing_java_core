package lesson3;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingDouble;

public class Homework2 {
    public static void main(String[] args) {

        // Домашка
        // Базовый уровень
        // Задание №1 - Написать цикл, который выводит через пробел 100 чисел с приставкой "a".
        // Ожидаемый результат: 1а 2а 3а .. 100а
        for (int i = 1; i < 101; i++) {
            System.out.println(i+"a");
        }
        //
        // Задание №2
        // Дано:
        int ageChildren = 10;
        // Задача: Написать условную конструкцию, которая в зависимости от возраста ребенка, отправляет его в учебное заведение
        // если ребенку до 6 лет то в сад, если до 11 лет в младшую школу, если до 17 лет в среднюю школу, иначе в университет
        // Отправляет - имеется в виду, печатает на экран: "пошел с сад", "пошел в младшую школу" и т.д.
        // Проверьте работоспособность условий, через изменение значения переменной.
        //
        if (ageChildren < 6) {
            System.out.println("П0шел в школу");
        } else if (ageChildren < 11) {
            System.out.println("Пошел в мл школу");
        } else if (ageChildren < 17) {
            System.out.println("Пошел в среднюю школу");
        } else {
            System.out.println("Пошел в университет");
        }
        // Задание №3
        // Дано:
        boolean chicken = true;
        boolean vegetables = false;
        boolean sour = true;
        boolean toast = true;
        boolean sausage = true;
        boolean eggs = true;
        // Задача: Повара попросили сделать салат.
        // Если у повара есть все ингредиенты для "Цезаря" (курица, овощи, соус и гренки), то лучше сделать "Цезарь".
        // Если для "Цезаря" ингредиентов не нашлось, то сделать Оливье (овощи, колбаса или курица, яйца).
        // Если и для Оливье не нашлось ингредиентов, то сделать Овощной салат (нужны только овощи).
        // Если ингредиентов нет, то повар объявляет: У меня ничего нет
        // Написать набор условий, приготовления салатов, по приоритету (от Цезаря к овощному). Либо объявить о невозможности сделать салат.
        // Ожидаемый результат: вывод на экран сделанного салата или объявление о том, что ничего нет.
        // Проверьте работоспособность условий, через изменение значения переменных.
        if (chicken && vegetables && sour && toast) {
            System.out.println("Цезарь");
        } else {
            if (vegetables && (sausage || chicken) && eggs) {
                System.out.println("Оливье");
            } else {
                if (vegetables) {
                    System.out.println("Овощной");
                } else {
                    System.out.println("Нет ввсех ингредиентов для салатов");
                }

            }
        }

        // Задание №4
        // Создать два класса, которые описывают какое либо животное (имеют два атрибута).
        // Написать к ним конструктор, сеттеры, геттеры.
        class Bird {
            boolean haveWings = true;
            boolean canWoof = false;
            // конструктор
            public Bird(boolean canWoof, boolean haveWings) {
                this.canWoof = canWoof;
                this.haveWings = haveWings;
            }
            //getters
            boolean isHaveWings() {
                return haveWings;
            }
            boolean isCanWoof() {
                return canWoof;
            }
            // setters
            void setHaveWings(boolean wings) {
                this.haveWings = wings;
            }
            void setCanWoof(boolean woof) {
                this.canWoof = woof;
            }
        }

        class Cat {
            String name;
            int tailSize;
            // конструктор
            public Cat(String name,int tailSize) {
                this.name = name;
                this.tailSize = tailSize;
            }
            //геттеры
            String getName() {
                return this.name;
            }
            int getTailSize() {
                return this.tailSize;
            }
            //сеттеры
            void setName(String name) {
                this.name = name;
            }
            void setTailSize(int size) {
                this.tailSize = size;
            }
        }

        // Продвинутый уровень
        // Задание №1: Написать цикл, который будет прибавлять число к result до тех пор,
        // пока не получиться больше 1_000_000.
        // Дано:
        double increment = 0.01123;
        double result = 0;

        // Вывести на экран, количество итераций, которое потребовалось, чтобы дойти до миллиона.
        // Если число отрицательное, то сразу заканчиваем цикл, ничего не выводя.
        // Внимание: число может измениться, и не должно приводить к изменению вашего кода.
        int counter = 0;
        while (result < 1000000) {
            if (result < 0) break;
            result += increment;
            ++counter;
        }
        System.out.println("result = "+result+" Количество итераций = " + counter);
        // Задание №2: Дан массив единиц, произвольной длины. Создать цикл, который заменяет каждый четный элемент на 0;
        // Например, дано: [1,1,1,1,1]
        // Ожидаемый результат: [0,1,0,1,0]
        // Подсказка: прочитай про операнд "%".
        int[] array = new int[] {1,1,1,1,1,1,1,1,1,1,1,1};
        for (int i = 0; i <array.length; i++) {
            array[i] = (int) i % 2 == 1 ? 1 : 0 ;
        }
        System.out.println(Arrays.toString(array));
        // Задание №3:
        // Дано:
        boolean hasFuel = true;
        boolean hasElectricsProblem = false;
        boolean hasMotorProblem = false;
        boolean hasTransmissionProblem = true;
        boolean hasWheelsProblem = true;
        // В автосервис приехала сломанная машина. Механики находят неисправность следующим способом:
        // Если у машины нет бензина и ничего не сломано, то отдают машину владельцу и берут 1000 рублей за консультацию.
        // Если у машины проблема с двигателем, то чинят и берут 10 000.
        // Если у машины проблема с электрикой, то чинят и берут 5000.
        // Если у машины проблема с коробкой передач, то чинят и берут 4000.
        // Если у машины проблема с колесами, то чинят и берут 2000.
        // Если две детали сломаны, то на общий счет идет скидка 10%.
        // Если сломана коробка передач, и электрика или двигатель, то на общий счет скидка 20%.
        // Если нет бензина и что-то сломано, то за консультацию денег не берут.
        // Ситуации, что бензин есть и ничего не сломано - быть не может.
        // Ожидаемый результат: выведен на экран счет клиенту.
        //Простыми ифами
        int invoice = 0;

        if (!hasFuel && !hasElectricsProblem && !hasMotorProblem && !hasTransmissionProblem && !hasWheelsProblem) {
            invoice = 1000;
        } else if (!hasFuel && (hasElectricsProblem || hasMotorProblem || hasTransmissionProblem || hasWheelsProblem)) {
            invoice = 0;
        }
        if (hasMotorProblem) { invoice += 10000; }
        if (hasElectricsProblem) { invoice += 5000; }
        if (hasTransmissionProblem) { invoice += 4000; }
        if (hasWheelsProblem) { invoice += 2000; }
        if ( (hasElectricsProblem && hasMotorProblem) ||
                (hasTransmissionProblem && hasWheelsProblem)  ||
                (hasMotorProblem && hasTransmissionProblem) ||
                (hasElectricsProblem && hasWheelsProblem)) {
            invoice = invoice - invoice/10;
        } else if (hasTransmissionProblem && (hasElectricsProblem || hasMotorProblem)) {
            invoice = invoice - invoice/20;
        }


        System.out.println("Счет: " + invoice);
        ///Классом
        class CarService {

            int invoice = 0;
            int countOfBrokenDetails = 0;

            boolean hasFuel;
            boolean hasElectricsProblem;
            boolean hasMotorProblem;
            boolean hasTransmissionProblem;
            boolean hasWheelsProblem;

            public CarService(boolean hasFuel, boolean hasElectricsProblem, boolean hasMotorProblem, boolean hasTransmissionProblem, boolean hasWheelsProblem) {
                this.hasElectricsProblem = hasElectricsProblem;
                this.hasFuel = hasFuel;
                this.hasMotorProblem = hasMotorProblem;
                this.hasTransmissionProblem = hasTransmissionProblem;
                this.hasWheelsProblem = hasWheelsProblem;
            }

            public int countInvoice() {
                if (!this.hasFuel && !this.hasTransmissionProblem && !this.hasWheelsProblem && !this.hasElectricsProblem && !this.hasMotorProblem) {
                    this.invoice = 1000;
                }
                if (this.hasMotorProblem) {
                    this.invoice += 1000;
                    ++this.countOfBrokenDetails;
                }
                if (this.hasElectricsProblem) {
                    this.invoice += 5000;
                    ++this.countOfBrokenDetails;
                }
                if (this.hasTransmissionProblem) {
                    this.invoice += 4000;
                    ++this.countOfBrokenDetails;
                }
                if (this.hasWheelsProblem) {
                    this.invoice += 2000;
                    ++this.countOfBrokenDetails;
                }

                if (!this.hasFuel && ( hasMotorProblem || hasTransmissionProblem || hasElectricsProblem || hasWheelsProblem)) {
                    this.invoice = 0;
                }
                if (invoice != 0) {
                    this.invoice = this.invoice - (this.invoice / 100 * this.discount());
                }
                return this.invoice;
            }

            private int discount() {
                int discount  = 0;
                if (this.countOfBrokenDetails == 2) {
                    discount = 10;
                    if (this.hasTransmissionProblem && (this.hasMotorProblem || this.hasElectricsProblem)) {
                        discount = 20;
                    }
                }
                return discount;
            }

        }
        CarService brokenCar = new CarService(hasFuel, hasElectricsProblem,hasMotorProblem,hasTransmissionProblem,hasWheelsProblem);
        System.out.println("Счет итого: " + brokenCar.countInvoice());



        // Задание №4:
        // Написать систему управления складскими запасами. Создать класс склад, создать класс работники
        // (написать геттеры на все аттрибуты).
        // Количество работников минимум 3.
        // Работники берут из склада товар, и портят его. Нужно написать взаимодействие через методы работников и склад:
        // Работник берет из склада товар, на складе товар уменьшается. Работник когда взял товар, выводит на экран
        // "Ура я испортил водку!" и добавляет к себе в журнал количество испорченного товара.
        // У склада есть только одна позиция - Водка.
        class Warehouse {
            public int vodkaAmount = 100;

            int getVodkaAmount() {
                return this.vodkaAmount;
            }
            void setVodkaAmount(int amount) {
                this.vodkaAmount = amount;
            }
        }

        class Worker {
            int brokenVodka = 0;

            public void getVodka(int amount, Warehouse warehouse) {
                warehouse.setVodkaAmount(warehouse.getVodkaAmount() - amount);
                this.brokenVodka += amount;
                System.out.println("Ура я испортил водку! (" + amount + ") штук и всего испортил "+this.getBrokenVodka());
            }

            int getBrokenVodka() {
                return this.brokenVodka;
            }
            void setBrokenVodka(int amount) {
                this.brokenVodka = amount;
            }
        }
        Warehouse warehouse = new Warehouse();

        Worker w1 = new Worker();
        w1.getVodka(10, warehouse);

        Worker w2 = new Worker();
        w2.getVodka(12, warehouse);
        w2.getVodka(11, warehouse);

        Worker w3 = new Worker();
        w3.getVodka(2, warehouse);

        System.out.println("Осталось целой водки на складе " + warehouse.vodkaAmount);

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
        //

        System.out.println("███████╗██╗  ██╗██████╗ ███████╗██████╗ ████████╗");
                System.out.println("██╔════╝╚██╗██╔╝██╔══██╗██╔════╝██╔══██╗╚══██╔══╝");
                        System.out.println("█████╗   ╚███╔╝ ██████╔╝█████╗  ██████╔╝   ██║   ");
                                System.out.println("██╔══╝   ██╔██╗ ██╔═══╝ ██╔══╝  ██╔══██╗   ██║");
                                        System.out.println("███████╗██╔╝ ██╗██║     ███████╗██║  ██║   ██║");
                                                System.out.println("╚══════╝╚═╝  ╚═╝╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝");
        System.out.println("===============Подзадача 1 ===============");
        Map<Integer, Map<String, String[]>> data = GeneratorExpertHomework.getData();
        // Регионы с количеством въехавших машин. Структура: количество машин - регион. Для сортировки
        Map <Integer, Integer> popularRegions =  new TreeMap<Integer, Integer>();

        data.forEach((key, value) -> {
            value.forEach((k, v) -> {
                if (k.equals("input")) {
                    popularRegions.put(key, v.length);
                }
            });
        });

        // упорядочиваем мапу с регионами по популярности. Дернул с интернетов :)
        Map<Integer, Integer> sortedMap = popularRegions.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));

        // ТОП-5: 98, 178, 01, 22, 33
        System.out.print("ТОП-5: ");

        sortedMap.entrySet().stream().limit(5).forEach((k) -> {
            // в данном случае ключ - значение региона, vflue - количество въездов
            System.out.print( k.getKey() + ", ");
        });
        System.out.println("");

        class ParserPlate {
            public String getReion(String numbr) {
                //String[] plateArray =  numbr.split("[А-Я]{1}[0-9]{3}[А-Я]{2}[0-9]{3}");
                // В общем у меня подгорело кресло от регулярок )
                return numbr.substring(numbr.length()-3, numbr.length());
            }
        }
        ParserPlate parser = new ParserPlate();
        // главная фиговина для вывода топ-5 регионов
        sortedMap.entrySet().stream().limit(5).forEach((k)-> {
            data.get(k.getKey()).forEach((n,v) -> {
               if (n.equals("input")) {
                    System.out.print(k.getKey() + " - больше всего въехало с номерами ");

                    Map<String, Integer> test= new HashMap<String, Integer>();
                    for (String s : v) {
                        String p = parser.getReion(s).toString();
                        if (!test.containsKey(p)) {
                            test.put(p,1);
                        } else {
                            int i = test.get(p) + 1;
                            test.put(p, i);
                        }
                  }
                    // так как нам не важно сколько регионов было с одинаковым количесвом въехавших машин,
                    // мы берем любой( в данном случае последний). Переворачиваем в TreeMap, который уже упорядочен.
                    TreeMap<Integer, String> sortedPates = new TreeMap<Integer, String>();
                    for (Map.Entry entry: test.entrySet()) {
                         sortedPates.put((Integer) entry.getValue(), (String) entry.getKey());
                    }
                    System.out.print(sortedPates.lastEntry().getValue() + ": "+sortedPates.lastEntry().getKey() + " машины \n");
             }
            });
        });

        //специальные номера
        HashSet<String> specialPlates = new HashSet<String>();

        data.forEach((key, value) -> {
            value.forEach((k, v) -> {
                for (String number: v) {
                    if (number.matches("[М]{1}[0-9]{3}[А]{1}[В]{1}[0-9]{3}")) {
                        specialPlates.add(number);
                    }
                }
            });
        });
        System.out.println("===============Подзадача 2 ===============");
        System.out.println("Всего со спецномерами " + specialPlates.size() +" машин");











    }


}
