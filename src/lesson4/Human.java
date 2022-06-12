package lesson4;

public class Human {
    //Статический атрибут
    static int count = 10;

    //Аттрибут
    String name;
    //Аттрибут(другие названия - поле,свойство)
    int age;

    //Конструктор
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Метод(другое название - функция)
    String getInfo() {
        return name + " " + age;
    }

    //Геттер - функция предназначенная для получения аттрибута
    String getName() {
        return name;
    }

    //Сеттер - функция предназначенная для установления аттрибута
    void setName(String name) {
        this.name = name;
    }
}
