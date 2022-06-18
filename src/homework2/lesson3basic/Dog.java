package homework2.lesson3basic;

public class Dog extends Animal{
    private static String name;

    public Dog(String newName, String kind, String subKind) {
        super(kind, subKind);
        name = newName;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String newName) {
        name = newName;
    }

}
