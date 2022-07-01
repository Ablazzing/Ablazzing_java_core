package lesson7;

public class Plane implements Flyable {
    private int countPassengers;

    public Plane(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    public void setCountPassengers(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    @Override
    public void fly() throws FlyException {
        try {
           if (countPassengers < 0) {
               throw new FlyException("пассажиров маловато");
           } else {
               System.out.println("Самолет летит");
           }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
