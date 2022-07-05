package lesson8;

/**
 * Класс Object, анонимные и вложенные классы.
 */
public class Lesson8ClassObject {
    public static void main(String[] args) throws Throwable {
        //Любой класс неявно наследуется от Object

        Object car1 = new MyCar("toyota");

        //Методы класса Object
        //Вывод на экран информации об объекте (по умолчанию выводиться ссылка памяти на объект)
        String hiToString = car1.toString();

        //Получение класс объекта
        Class<?> hiClass = car1.getClass();

        //Сравнение двух объектов
        MyCar car2 = new MyCar("toyota");
        boolean isEqual = car1.equals(car2);

        //Получение краткого числового представления об объекте (hashcode)
        int hashCode = car1.hashCode();

        //Клонирование объекта (Получение нового объекта, с такими же атрибутами)
        MyCar car3 = ((MyCar) car1).clone();

        //Вызов кода при удалении объекта
        ((MyCar) car1).finalize();
        Runtime.getRuntime().gc();

        //Относятся к многопоточности, на этой лекции рассматриваться не будут
        car1.wait();
        car1.notify();
        car1.notifyAll();
    }
}
