package lesson7.homework_advanced.task2;

import lesson7.homework_base.task1.FlyException;

public class Watch {
    private boolean isBroken;

    public Watch(boolean isBroken) {
        this.isBroken = isBroken;
    }

    public void tick() throws WatchBrokenError {
        if (isBroken) {
            throw new WatchBrokenError("Ошибка: Часы сломались");
        }
        System.out.println("Часы тикают");
    }
}
