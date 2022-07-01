package homework4.lesson7basic;

public class Plane implements FlyingObject {

    public int countPassengers;

    public Plane(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    @Override
    public void canFly() throws FlyException {
        if (countPassengers < 0) {
            throw new FlyException("Ошибка: пассажиров в самолете меньше 0");
        }
        System.out.println("самолёт летит");

    }
}
