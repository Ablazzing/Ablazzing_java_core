package lesson7;

public class Lesson7 {
    public static void main(String[] args) {
        int number = 3;

        //try - показывает, что внутри блока будут ошибки, которые мы будем проверять
        try {
            //Мы можем выкинуть свою ошибку, используя ключевое слово throw:
            //Для этого нужно создать объект, который реализует интерфейс Throwable
            //Например в данном случае класс Exception реализует интерфейс Throwable
            throw new Exception("Ошибка!");

            //Если раскомментировать строку ниже, то она не выполнится, так как ошибка сверху прервет выполнение кода
            //System.out.println("Все работает прекрасно, без ошибок");

            //catch - является обработчиком ошибок определенного класса.
            //Когда появляется ошибка, catch сравнивает класс ошибки с тем, который мы указали
            //Если классы совпадают, то в переменную (в данном случае "e") попадает объект ошибки (в данном случае объект из 13 строки)
        } catch (Exception e) {
            System.out.println("Вылетела ошибка");
            e.printStackTrace();

            //finally - это блок кода, который выполнится всегда (кроме системных ошибок java)
        } finally {
            System.out.println("Выполнится в независимости от наличия ошибок");
        }

        try {
            checkNumber(number);
            checkIsOdd(number);
            //Мы можем создавать свои классы ошибок наследуясь от Exception или RuntimeException
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        } catch (EvenNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkNumber(int a) throws NegativeNumberException {
        if (a < 0) {
            throw new NegativeNumberException("Ошибка: Число " + a + " меньше 0");
        }
        System.out.println("число положительное или 0");
    }

    public static void checkIsOdd(int a) throws EvenNumberException {
        if (a % 2 != 0) {
            throw new EvenNumberException("Ошибка: Число " + a + " нечетное");
        }
        System.out.println("число четное");
    }


}
