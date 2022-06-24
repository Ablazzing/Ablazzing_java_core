package homework1;

public class Lesson1Basic {
        public static void main(String[] args) {

//Базовый уровень
//Задача №1
//Дано (их менять нельзя)
                String hi = "                Hello ";
                String world = " WoRld!";
                char newLine = '\n';
//Создать из трех переменных единую строку,
//Привести к правильному виду (Ниже)
//затроить (Можно вызвать тольку одну команду System.out.print())
//
//Результат вывода на экран:
//Hello world!
//Hello world!
//Hello world!

                String str = "";
                str += hi.trim() + world.toLowerCase() + newLine + hi.trim() + world.toLowerCase() + newLine + hi.trim() + world.toLowerCase();
                System.out.println(str);

//Задача №2
//Создать переменные с ростом, весом.
//Произвести расчет индекса массы тела (вес) / (рост * рост) используя переменные, вывести на экран
//Пример результата вывода на экран:
//21.0

                double weight = 90.0;
                double height = 1.4;
                double indexOfMass = (weight) / (height * height);
                System.out.println(indexOfMass);


//Задача №3
//Создать из массива букв a,b,c,d,e, строку,вывести на экран , поменять в массиве 4 букву по счету на h,
//и снова создать строку, вывести на экран

                char[] chars = {'a', 'b', 'c', 'd', 'e'};
                char x = 'h';

                String str1 = String.valueOf(chars);
                System.out.println(str1);

                chars[3] = x;

                String str2 = String.valueOf(chars);
                System.out.println(str2);
        }
}