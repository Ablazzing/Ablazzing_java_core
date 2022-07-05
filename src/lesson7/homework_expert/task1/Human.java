package lesson7.homework_expert.task1;

public class Human {
    private int age;
    private int weight;
    private String name;

    public void info() {
        System.out.println("инфо о человеке:"
                + " возраст " + age
                + " вес " + weight
                + " имя " + name);
    }

    private Human() {
    }

    public static HumanBuilder builder() {
        return new HumanBuilder();
    }

    public static class HumanBuilder {
        private Human human;

        public HumanBuilder() {
            this.human = new Human();
        }

        public HumanBuilder name(String name) {
            this.human.setName(name);
            return this;
        }

        public HumanBuilder age(int age) {
            this.human.setAge(age);
            return this;
        }

        public HumanBuilder weight(int weight) {
            this.human.setWeight(weight);
            return this;
        }

        public Human build() {
            return human;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
