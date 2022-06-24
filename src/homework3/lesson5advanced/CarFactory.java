package homework3.lesson5advanced;

import homework3.lesson5basic.Lada;
import homework3.lesson5basic.Toyota;

public class CarFactory {

    public static Lada makeLada() {
        Lada lada = new Lada();
        return lada;
    }

    public static Toyota makeToyota() {
        Toyota toyota = new Toyota();
        return toyota;
    }

}
