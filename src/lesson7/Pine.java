package lesson7;

public class Pine implements Tree {

    public void hasPinecone() {
        System.out.println("есть шишки");
    }

    @Override
    public String canSmell() {
        return "умеет пахнуть";
    }

}
