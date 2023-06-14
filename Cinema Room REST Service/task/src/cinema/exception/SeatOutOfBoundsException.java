package cinema.exception;

public class SeatOutOfBoundsException extends RuntimeException{
    private static final String MESSAGE = "The number of a row or a column is out of bounds!";

    public SeatOutOfBoundsException() {
        super(MESSAGE);
    }
}
