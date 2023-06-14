package cinema.controller.advice;

import cinema.exception.AlreadyPurchasedException;
import cinema.exception.SeatOutOfBoundsException;
import cinema.exception.WrongPasswordException;
import cinema.exception.WrongTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerAdvice {
    @ExceptionHandler({
            AlreadyPurchasedException.class,
            SeatOutOfBoundsException.class,
            WrongTokenException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorDTO badRequestErrors(Exception ex) {
        return new ErrorDTO(ex.getMessage());
    }

    @ExceptionHandler({
            WrongPasswordException.class
    })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    ErrorDTO unauthorizedError(Exception ex) {
        return new ErrorDTO(ex.getMessage());
    }

    public record ErrorDTO(String error) {
    }
}
