package tddProject.exception;

public class NumberTooLargeException extends RuntimeException {
    public NumberTooLargeException(String message) {
        super(message);
    }
}
