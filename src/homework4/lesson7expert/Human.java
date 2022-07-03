package homework4.lesson7expert;

public class Human {
    private String name;
    private int age;
    private double weight;

    private Human(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public static HumanBuilder builder() {
        HumanBuilder humanBuilder = new HumanBuilder();
        return humanBuilder;
    }

    static class HumanBuilder {
        private Human newHuman;

        public void name(String name) {
            newHuman.name = name;
        }

        public void age(int age) {
            newHuman.age = age;
        }

        public void weight(double weight) {
            newHuman.weight = weight;
        }

        public static Human build() {

            return Human;
        }
    }
}
