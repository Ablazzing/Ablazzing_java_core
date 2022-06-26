package lesson7;

public class Lesson7 {
    public static void main(String[] args) {
        int number = 3;
        try {
            if (number == 1) {
                throw new Exception("Ошибка!");
            }
            System.out.println("Все работает прекрасно, без ошибок");
        } catch (Exception e) {
            System.out.println("Вылетела ошибка");
            e.printStackTrace();
        } finally {
            System.out.println("Выполнится в независимости от наличия ошибок");
        }

        try {
            checkNumber(number);
            checkIsOdd(number);
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        } catch (EvenNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkNumber(int a) throws NegativeNumberException {
        if (a < 0) {
            throw new NegativeNumberException("Ошибка: Число " + a + " меньше 0" );
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
