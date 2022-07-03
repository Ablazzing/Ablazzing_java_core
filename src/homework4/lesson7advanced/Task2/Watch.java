package homework4.lesson7advanced.Task2;

public class Watch {
    private boolean clockIsTicking;

    public void ticking() throws WatchBrokenException {
        if (clockIsTicking) {
            System.out.println("Часы тикают");
        } else {
            throw new WatchBrokenException("Ошибка: Часы сломались.");
        }
    }

    public Watch(boolean clockIsTicking) {
        this.clockIsTicking = clockIsTicking;
    }

    public boolean isClockIsTicking() {
        return clockIsTicking;
    }
}
