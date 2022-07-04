package homework4.lesson7expert;

public class Human {
    private String name;
    private int age;
    private double weight;

    public void info() {
        String a = getName();
        int b = getAge();
        double c = getWeight();
        System.out.printf("%s - возраст %s, вес - %s", a, b, c);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public static class Builder {
        private Human newHuman;

        public Builder(){
            newHuman = new Human();
        }

        public Builder name(String name) {

            newHuman.name = name;
            return this;
        }
        public Builder age(int age) {

            newHuman.age = age;
            return this;
        }
        public Builder weight(double weight) {

            newHuman.weight = weight;
            return this;
        }

        public Human build() {
            return newHuman;
        }

    }





}
