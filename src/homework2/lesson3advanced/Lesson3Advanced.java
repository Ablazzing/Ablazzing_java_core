package homework2.lesson3advanced;

import java.util.Arrays;

public class Lesson3Advanced {
    public static void main(String[] args) {
        // Продвинутый уровень
        // Задание №1: Написать цикл, который будет прибавлять число к result до тех пор,
        // пока не получиться больше 1_000_000.
        // Дано:
        double increment = 0.01123;
        double result = 0.0;
        // Вывести на экран, количество итераций, которое потребовалось, чтобы дойти до миллиона.
        // Если число отрицательное, то сразу заканчиваем цикл, ничего не выводя.
        // Внимание: число может измениться, и не должно приводить к изменению вашего кода.
        if (increment > 0) {
            int count = 0;
            while (result < 1000000.0) {
                result += increment;
                count++;
            }
            System.out.println(count);
        }

        // Задание №2: Дан массив единиц, произвольной длины. Создать цикл, который заменяет каждый четный элемент на 0;
        // Например, дано: [1,1,1,1,1]
        // Ожидаемый результат: [0,1,0,1,0]
        // Подсказка: прочитай про операнд "%".

        int[] array = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));

        // Задание №3:
        // Дано:
        boolean hasFuel = false;
        boolean hasElectricsProblem = false;
        boolean hasMotorProblem = true;
        boolean hasTransmissionProblem = false;
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

        int malfunctionNumber = 0;
        int endPrice = 0;
        boolean specialOffer = hasTransmissionProblem && hasMotorProblem || hasElectricsProblem;


        if (hasMotorProblem) {
            System.out.println("проблема с двигателем, чинят и берут 10 000");
            malfunctionNumber++;
            endPrice += 10000;
        }

        if (hasElectricsProblem) {
            System.out.println("проблема с электрикой, чинят и берут 5000");
            malfunctionNumber++;
            endPrice += 5000;
        }

        if (hasTransmissionProblem) {
            System.out.println("проблема с коробкой передач, чинят и берут 4000");
            malfunctionNumber++;
            endPrice += 4000;
        }

        if (hasWheelsProblem) {
            System.out.println("проблема с колесами, чинят и берут 2000");
            malfunctionNumber++;
            endPrice += 2000;
        }

        if (malfunctionNumber > 1 && !specialOffer) {
            System.out.println("две детали сломаны, скидка 10%");
            endPrice *= 0.9;
        } else if (specialOffer) {
            System.out.println("сломана коробка передач, и электрика или двигатель, скидка 20%");
            endPrice *= 0.8;
        }

        if (hasFuel && malfunctionNumber > 0) {
            System.out.println("есть бензин и что-то сломано 1000 рублей за консультацию");
            System.out.println();
            endPrice += 1000;
        } else if (!hasFuel && malfunctionNumber > 0) {
            System.out.println("нет бензина и что-то сломано 0 рублей за консультацию");
            System.out.println();
        } else if (!hasFuel && malfunctionNumber == 0) {
            System.out.println("нет бензина и ничего не сломано 1000 рублей за консультацию");
            System.out.println();
            endPrice += 1000;
        }
        System.out.println("Итого: " + endPrice);

        // Задание №4:
        // Написать систему управления складскими запасами. Создать класс склад, создать класс работники
        // (написать геттеры на все аттрибуты).
        // Количество работников минимум 3.
        // Работники берут из склада товар, и портят его. Нужно написать взаимодействие через методы работников и склад:
        // Работник берет из склада товар, на складе товар уменьшается. Работник когда взял товар, выводит на экран
        // "Ура я испортил водку!" и добавляет к себе в журнал количество испорченного товара.
        // У склада есть только одна позиция - Водка.

        Workers worker1 = new Workers("Vasya",1);
        Workers worker2 = new Workers("Fedya", 2);
        Workers worker3 = new Workers("Petya", 3);


        worker1.annihilatingVodka(10);
        System.out.println(Workers.getAnnihilatedVodka());
        System.out.println(Storage.getVodka());
        
        worker2.annihilatingVodka(160);
        System.out.println(Workers.getAnnihilatedVodka());
        System.out.println(Storage.getVodka());

        worker3.annihilatingVodka(1500);
        System.out.println(Workers.getAnnihilatedVodka());
        System.out.println(Storage.getVodka());







    }
}
