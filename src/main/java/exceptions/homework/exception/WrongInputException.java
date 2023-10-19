package exceptions.homework.exception;

public abstract class WrongInputException extends RuntimeException{
    public WrongInputException(String message) {
        super(message);
    }
}
