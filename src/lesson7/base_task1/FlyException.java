package lesson7.base_task1;

public class FlyException extends Exception {
    public FlyException(String message) {
        super("Error: "+message);
    }
}
