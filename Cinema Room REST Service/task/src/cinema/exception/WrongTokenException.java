package cinema.exception;

public class WrongTokenException extends RuntimeException{
    private static final String MESSAGE = "Wrong token!";

    public WrongTokenException() {
        super(MESSAGE);
    }
}
