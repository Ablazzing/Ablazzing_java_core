package lesson7;

public class FlyException extends Exception {
    public FlyException(String message) {
        super("Error: "+message);
    }
}
