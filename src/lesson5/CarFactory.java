package lesson5;

    public abstract class CarFactory extends Car {
        public CarFactory() {
        }

        static Zhiguli createZ() {
            return new Zhiguli();
        }

        static Toyota createT() {
            return new Toyota();
        }
    }


