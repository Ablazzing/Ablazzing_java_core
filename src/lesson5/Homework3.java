package lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Homework3 {
    public static void main(String[] args) throws IOException {
        //Базовый уровень (для зачета нужно сделать хотя мобы 2 из 3)
        //Задача №1
        //Дано: у нас есть две модели машин - жигули и toyota. Каждая из этих машин умеет: начинать движение,
        //останавливаться, включать фары. У жигули есть особенность: она ломается. У Toyota особенность: включает музыку
        //Необходимо:
        // 1.Создать абстрактный класс, который будет описывать общие действия этих машин (методы будут не абстрактные)
        // 2.Создать два класса, которые будут наследоваться от абстрактного класса, и реализовывать особенности этих машин
        // Методы должны просто печатать на экран действия машин (начал движение, включил музыку и тд.)
        Zhiguli zhiguli = new Zhiguli();
        zhiguli.startMoving();
        zhiguli.stop();
        zhiguli.turnHeadlights();
        zhiguli.problem();

        Toyota toyota = new Toyota();
        toyota.startMoving();
        toyota.stop();
        toyota.turnHeadlights();
        toyota.turnMysicOn();
        //Задача №2
        //Необходимо:
        // 1. Создать папку resource, пометить ее как папку Resourсe root.
        // 2. Создать в ней файл "my_first_file.txt". На первой строке написать: "Моя бабушка", на второй: "читает газету жизнь"
        // 3. Прочитать файл, и вывести на экран все слова файла в одну строку
        // Ожидаемый результат: "Моя бабушка читает газету жизнь"
        FileWriter file = new FileWriter("/Users/nikitaveselov/IdeaProjects/Ablazzing_java_core1/resource/my_first_file.txt");
        try {
            file.write("Моя бабушка\nЧитает газету жизнь");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        file.close();
        BufferedReader fileBuffer = new BufferedReader(new FileReader("/Users/nikitaveselov/IdeaProjects/Ablazzing_java_core1/resource/my_first_file.txt"));
        fileBuffer.lines().forEach((e) -> {
            System.out.println(e);
        });
        //Задача №3
        //Необходимо:
        // 1. Создать класс Financial record, с двумя атрибутами: incomes, outcomes (доходы, расходы)
        // 2. Создать в этом классе геттеры, сеттеры и конструктор на все атрибуты
        // 3. Создать объект этого класса прямо здесь (class Homework3, метод main), с доходами 500, расходами 300
        // 4. Записать в файл "report.txt" данные из объекта класса.
        // Ожидаемый результат: в файле report.txt - одна строка: доходы = 500, расходы 300
        FinancialRecord financialRecord = new FinancialRecord(500, 300);
        FileWriter financialFile = new FileWriter("/Users/nikitaveselov/IdeaProjects/Ablazzing_java_core1/resource/report.txt");
        financialFile.write(" доходы: " + financialRecord.getIncome() + ", расходы: " + financialRecord.getOutcome());
        financialFile.close();

        //Продвинутый уровень
        //Задача №1
        // Сделать задачу №1 из базовой.
        // 1. Создать класс CarFactory, у которого есть два статических методы: создать жигули, создать toyota.
        // 2. Создать 20 тойот, 20 жигулей с помощью CarFactory, положить их в один массив.
        // 3. Пройтись по массиву, проверить к какому классу принадлежит машина, привести тип к классу машины
        // и вызвать характерные для нее методы.
        CarFactory[] cars = new CarFactory[40];
        Random r = new Random();

        for(int i = 0; i < 40; ++i) {
            cars[i] = r.nextBoolean() ? CarFactory.createZ() : CarFactory.createT();
        }


        for (CarFactory car : cars) {
            if (car instanceof Toyota) {
                Toyota t = (Toyota) car;
                t.turnMysicOn();
            } else if (car instanceof Zhiguli) {
                Zhiguli z = (Zhiguli) car;
                z.problem();
            }
        }

        //Задача №2
        // 1. Создать класс Financial record, с двумя атрибутами: incomes, outcomes (доходы, расходы)
        // 2. Создать в этом классе геттеры, сеттеры и конструктор на все атрибуты
        // 3. Создать 10 отчетов, с разными доходами и расходами (Смотри класс new Random(1).nextInt(10000) )
        // 4. Записать в файл "report.txt" все данные из отчетов.
        // 5. Прочитать файл report.txt, просуммировать все доходы и вывести на экран, тоже самое с расходами
        // Ожидаемый результат: общие доходы - (какое то число), общие расходы - (какое то число)
        FileWriter reportFile = new FileWriter("/Users/nikitaveselov/IdeaProjects/Ablazzing_java_core1/resource/report2.txt");
        Random randI = new Random();

        for(int i = 0; i < 10; ++i) {
            FinancialRecord f = new FinancialRecord(randI.nextInt(10), randI.nextInt(100));
            reportFile.write("" + f.getIncome() + ";" + f.getOutcome() + "\n");
        }
        reportFile.close();

        BufferedReader readReportFile = new BufferedReader(new FileReader("/Users/nikitaveselov/IdeaProjects/Ablazzing_java_core1/resource/report2.txt"));
        ArrayList<Integer> arrayOfIncomes = new ArrayList<>();
        ArrayList<Integer> arrayOfOutcomes = new ArrayList<>();
        readReportFile.lines().forEach((line) -> {
            String[] l = line.split(";");
            arrayOfIncomes.add(Integer.parseInt(l[0]));
            arrayOfOutcomes.add(Integer.parseInt(l[1]));
        });
        int suI = 0;
        int suO = 0;
        int sO;
        for (int a: arrayOfIncomes) {
            suI += a;
        }
        for (int a: arrayOfOutcomes) {
            suO += a;
        }

        System.out.println("Общие доходы - " + suI + ", общие расходы - " + suO);

        //Экспертный уровень
        // Дано: папка, внутри которой находятся файлы, следующего именования - report_01_2012.txt, где 01 - месяц, 2012 - год
        // Внутри файла следующий формат:
        // pyterochka;122300.20;100312.10;20/01/2012
        // pyterochka;299922.00;323333.02;21/01/2012
        // perekrestok;9920.20;28200.01;21/01/2012
        // Где pyterochka - название магазина; 122300.20 - доход; 100312.10 - расход, 20/01/2012 - дата операции
        //Читать файлы нужно через
        //String s = Homework3.class.getClassLoader().getResource("report_03_2012.txt").toString();
        //System.out.println(s);

        // Задача №1
        // Необходимо составить отчет о итоговой прибыли за каждый месяц по магазину pyterochka
        // Формат ожидаемого результат:
        // Прибыль по магазину pyterochka по месяцам
        // 01.2012: 20000.00
        // 02.2012: -100332.00
        // и тд


        // Задача №2
        // Необходим составить отчет о расходах всех магазинов за весь период по магазинам (т.е. прочитать все файлы внутри папки)
        // Формат ожидаемого результат:
        // Расходы pyterochka за весь период: 20032220.00
        // Расходы perekrestok за весь период: 1734220.00
        // .. и тд
    }
}
