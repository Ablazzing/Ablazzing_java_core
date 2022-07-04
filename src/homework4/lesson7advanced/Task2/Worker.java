package homework4.lesson7advanced.Task2;

public class Worker extends Watch {

    public Worker(Watch watch) {
        super(watch.isClockIsTicking());
    }
}
