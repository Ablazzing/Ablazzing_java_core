package lesson5;

    public class CarFactory {
        public CarFactory() {
        }

        static Zhiguli createZ() {
            return new Zhiguli();
        }

        static Toyota createT() {
            return new Toyota();
        }
    }


