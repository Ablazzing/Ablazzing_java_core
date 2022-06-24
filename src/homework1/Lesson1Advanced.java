package homework1;

public class Lesson1Advanced {
    public static void main(String[] args) {
        //Продвинутый уровень
//Задача №1
//Произвести преобразование "234" в число типа int и прибавить к этому числу длину строки "some_text"

        String strA = "234";
        String strB = "some_text";
        int x = Integer.parseInt(strA);
        System.out.println(x+=strB.length());

//Задача №2
//Посчитать (a+b)^2 = ?, при a=3, b=5

        int a = 3;
        int b = 5;
        double result = Math.pow((a + b), 2);
        System.out.println(result);

//Задача №3
//Создать два массива чисел:
// 1,2,5,7,10
// 2,3,2,17,15
// Создать массив чисел, в котором будут: все числа из этих двух массивов,
// и результат умножения чисел с одинаковым порядковым номером
//
//Ожидаемый результат:
//1,2,5,7,10,2,3,2,17,15,2,6,10,119,150
//(первый массив - 1,2,5,7,10), (второй массив - 2,3,2,17,15),
//(результат перемножения - (1*2), (2*3), (5*2), (7*17), (10*15)

        int[] array1 = {1, 2, 5, 7, 10};
        int[] array2 = {2, 3, 2, 17, 15};
        int[] array3 = new int[15];
        int count = 0;

        for (int i = 0; i < 5; i++) {
            array3[count] = array1[i];
            System.out.print(array3[count]+",");
            count++;
        }

        for (int i = 0; i < 5; i++) {
            array3[count] = array2[i];
            System.out.print(array3[count]+",");
            count++;
        }

        for (int i = 0; i < 5; i++) {
            array3[count] = array1[i] * array2[i];
            System.out.print(array3[count]+",");
            count++;
        }
        System.out.println();


//Задача №4
//В слове "Hello world!" заменить все l на r, сделать все буквы заглавными, выбрать первые 8 символов

        String str1 = "Hello world!";
        String replace = str1.replace('l', 'r');
        String str2 = replace.substring(0, 8);
        System.out.println(str2.toUpperCase());


    }
}
