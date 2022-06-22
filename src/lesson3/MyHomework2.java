package lesson3;

public class MyHomework2 {

    // Домашка
    // Базовый уровень
    // Задание №1 - Написать цикл, который выводит через пробел 100 чисел с приставкой "a".
    // Ожидаемый результат: 1а 2а 3а .. 100а
    public static void printDigitPlus() {
        System.out.println("Задание № 1. Базовый уровень.");
        for (int i = 1; i < 101; i++) {
            System.out.print(i + "a ");
        }
        System.out.println();
        System.out.println();
    }

    // Задание №2
    // Дано:
    // Задача: Написать условную конструкцию, которая в зависимости от возраста ребенка, отправляет его в учебное заведение
    // если ребенку до 6 лет то в сад, если до 11 лет в младшую школу, если до 17 лет в среднюю школу, иначе в университет
    // Отправляет - имеется в виду, печатает на экран: "пошел с сад", "пошел в младшую школу" и т.д.
    // Проверьте работоспособность условий, через изменение значения переменной.
    public static void childToGo(int ageChildren) {
        System.out.println("Задание № 2. Базовый уровень.");
        if (ageChildren >= 17) {
            System.out.println("пошёл в университет");
        } else if (ageChildren >= 11) {
            System.out.println("пошёл в среднюю школу");
        } else if (ageChildren >= 6) {
            System.out.println("пошёл в младшую школу");
        } else {
            System.out.println("пошёл в сад");
        }
        System.out.println();
    }

    // Задание №3
    // Дано:
    // Задача: Повара попросили сделать салат.
    // Если у повара есть все ингредиенты для "Цезаря" (курица, овощи, соус и гренки), то лучше сделать "Цезарь".
    // Если для "Цезаря" ингредиентов не нашлось, то сделать Оливье (овощи, колбаса или курица, яйца).
    // Если и для Оливье не нашлось ингредиентов, то сделать Овощной салат (нужны только овощи).
    // Если ингредиентов нет, то повар объявляет: У меня ничего нет
    // Написать набор условий, приготовления салатов, по приоритету (от Цезаря к овощному). Либо объявить о невозможности сделать салат.
    // Ожидаемый результат: вывод на экран сделанного салата или объявление о том, что ничего нет.
    // Проверьте работоспособность условий, через изменение значения переменных.
    public static void salad(boolean chicken, boolean vegetables, boolean sour, boolean toast, boolean sausage, boolean eggs) {
        System.out.println("Задание №3");
        if (chicken && vegetables && sour && toast) {
            System.out.println("Цезарь");
        } else if (vegetables && sausage && chicken && eggs) {
            System.out.println("Оливье");
        } else if (vegetables) {
            System.out.println("Овощной салат");
        } else {
            System.out.println("У меня ничего нет");
        }
        System.out.println();
    }

    // Продвинутый уровень
    // Задание №1: Написать цикл, который будет прибавлять число к result до тех пор,
    // пока не получиться больше 1_000_000.
    // Вывести на экран, количество итераций, которое потребовалось, чтобы дойти до миллиона.
    // Если число отрицательное, то сразу заканчиваем цикл, ничего не выводя.
    // Внимание: число может измениться, и не должно приводить к изменению вашего кода.
    public static void iterNum(double result, double increment) {
        System.out.println("Задание №1. Продвинутый уровень");
        int iter = 0;
        while (result <= 1_000_000){
            result += increment;
            if (result < 0) {
                break;
            }
            iter++;
        }
        System.out.println(iter);
        System.out.println();
    }

    // Задание №2: Дан массив единиц, произвольной длины. Создать цикл, который заменяет каждый четный элемент на 0;
    // Например, дано: [1,1,1,1,1]
    // Ожидаемый результат: [0,1,0,1,0]
    // Подсказка: прочитай про операнд "%".
    public static void changeArray(int[] arr) {
        System.out.println("Задание №2. Продвинутый уровень");
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = 0;
            }
        }
        for (int n: arr
             ) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Задание №3:
    // Дано:
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
    public static void repairPrice(boolean hasFuel, boolean hasElectricsProblem,
                                   boolean hasMotorProblem, boolean hasTransmissionProblem,
                                   boolean hasWheelsProblem) {
        System.out.println("Задание №3. Продвинутый уровень");
        if (!hasFuel && !hasElectricsProblem && !hasMotorProblem && !hasWheelsProblem && !hasTransmissionProblem) {
            System.out.println("1000");
        } else if (hasMotorProblem && !hasElectricsProblem && !hasWheelsProblem && !hasTransmissionProblem) {
            System.out.println("10_000");
        } else if (hasElectricsProblem && !hasMotorProblem && !hasWheelsProblem && !hasTransmissionProblem) {
            System.out.println("5000");
        } else if (hasTransmissionProblem && !hasElectricsProblem && !hasMotorProblem && !hasWheelsProblem) {
            System.out.println("4000");
        } else if (hasWheelsProblem && !hasElectricsProblem && !hasMotorProblem && !hasTransmissionProblem) {
            System.out.println("2000");
        } else if (hasElectricsProblem && hasMotorProblem && !hasWheelsProblem && !hasTransmissionProblem) {
            System.out.println("13500");
        } else if (hasElectricsProblem && !hasMotorProblem && hasWheelsProblem && !hasTransmissionProblem) {
            System.out.println("6300");
        } else if (hasElectricsProblem && !hasMotorProblem && !hasWheelsProblem && hasTransmissionProblem) {
            System.out.println("7200");
        } else if (!hasElectricsProblem && hasMotorProblem && hasWheelsProblem && !hasTransmissionProblem) {
            System.out.println("10800");
        } else if (!hasElectricsProblem && hasMotorProblem && !hasWheelsProblem && hasTransmissionProblem) {
            System.out.println("11200");
        } else if (!hasElectricsProblem && !hasMotorProblem && hasWheelsProblem && hasTransmissionProblem) {
            System.out.println("5400");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Задание №1 - Написать цикл, который выводит через пробел 100 чисел с приставкой "a".
        printDigitPlus();

        // Задание №2
        int ageChildren = 10;
        childToGo(ageChildren);

        // Задание №3
        boolean chicken = true;
        boolean vegetables = true;
        boolean sour = true;
        boolean toast = false;
        boolean sausage = true;
        boolean eggs = true;
        salad(chicken, vegetables, sour, toast, sausage, eggs);

        // Задание №4
        // Создать два класса, которые описывают какое либо животное (имеют два атрибута).
        // Написать к ним конструктор, сеттеры, геттеры.
        Cat cat = new Cat("meow", 4);
        Dog dog = new Dog("woof", 4);
        System.out.println(cat.getVoice() + " " + dog.getVoice());
        System.out.println();

        // Продвинутый уровень
        // Задание №1: Написать цикл, который будет прибавлять число к result до тех пор,
        // пока не получиться больше 1_000_000.
        double increment = 0.01123;
        double result = 0;
        iterNum(result, increment);

        // Задание №2: Дан массив единиц, произвольной длины. Создать цикл, который заменяет каждый четный элемент на 0;
        int[] arr = {1,1,1,1,1};
        changeArray(arr);

        // Задание №3:
        boolean hasFuel = true;
        boolean hasElectricsProblem = false;
        boolean hasMotorProblem = false;
        boolean hasTransmissionProblem = true;
        boolean hasWheelsProblem = true;
        repairPrice(hasFuel, hasElectricsProblem, hasMotorProblem, hasTransmissionProblem, hasWheelsProblem);

        // Задание №4:
        // Написать систему управления складскими запасами. Создать класс склад, создать класс работники
        // (написать геттеры на все аттрибуты).
        // Количество работников минимум 3.
        // Работники берут из склада товар, и портят его. Нужно написать взаимодействие через методы работников и склад:
        // Работник берет из склада товар, на складе товар уменьшается. Работник когда взял товар, выводит на экран
        // "Ура я испортил водку!" и добавляет к себе в журнал количество испорченного товара.
        // У склада есть только одна позиция - Водка.
        Stock stock = new Stock();
        Employee emp1 = new Employee("Ivan", stock);
        Employee emp2 = new Employee("Petr", stock);
        Employee emp3 = new Employee("Yuri", stock);
        emp1.destroyVodka();
        System.out.println(stock.getVodka());
        emp2.destroyVodka();
        emp2.destroyVodka();
        System.out.println(stock.getVodka());
        emp3.destroyVodka();
        emp3.destroyVodka();
        emp3.destroyVodka();
        System.out.println(stock.getVodka());
        System.out.println(emp1.getJournal());
        System.out.println(emp2.getJournal());
        System.out.println(emp3.getJournal());


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
    }
}
