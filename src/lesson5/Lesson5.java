package lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lesson5 {
    public static void main(String[] args) throws IOException {
        //Полиморфизм
        Cat cat = new Cat();
        Dog dog = new Dog();
        Animal cat2 = new Cat();
        Animal cat3 = new Cat();
        Animal dog2 = new Dog();
        Animal dog3 = new Dog();
        Animal[] animals = {cat2, cat3, dog2, dog3};
        for (Animal animal : animals) {
            animal.eat();
            if (animal instanceof Cat) {
                Cat myCat = (Cat) animal;
                myCat.sayMyay();
            }
        }

        //Чтение файла
        FileReader fileReader = new FileReader("resource/test.txt");
        String result = "";
        while (fileReader.ready()) {
            int read = fileReader.read();
            result += (char) read;
        }
        fileReader.close();
        System.out.println(result);

        //Перезапись файла (все что было в файле, если он существовал, пропадет)
        FileWriter fileWriter = new FileWriter("resource/test2.txt");
        fileWriter.write("проба пера");
        fileWriter.close();

        //Добавление в файл
        FileWriter fileWriter2 = new FileWriter("resource/test2.txt", true);
        fileWriter2.write("\nвторая проба пера");
        fileWriter2.close();

        //BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader("resource/test2.txt"));
        while (bufferedReader.ready()) {
            String row = bufferedReader.readLine();
            System.out.println(row);
        }
    }
}
