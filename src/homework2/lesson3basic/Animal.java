package homework2.lesson3basic;

public class Animal {
    private static String kind;
    private static String subKind;

    public Animal(String newKind, String newSubKind) {
        kind = newKind;
        subKind = newSubKind;
    }

    public static String getKind() {
        return kind;
    }

    public static void setKind(String newKind) {
        kind = newKind;
    }

    public static String getSubKind() {
        return subKind;
    }

    public static void setSubKind(String newSubKind) {
        subKind = newSubKind;
    }
}
