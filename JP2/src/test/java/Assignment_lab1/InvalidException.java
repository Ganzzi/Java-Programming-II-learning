package Assignment_lab1;

public class InvalidException extends Exception {

    public InvalidException() {
        super("Something wrong");
    }

    public InvalidException(String e) {
        super(e);
    }
}
