package exceptions.homework.exception;

public class WrongDataAmountException extends WrongInputException{
    private int dataLength;

    public int getDataLength() {
        return dataLength;
    }

    public WrongDataAmountException(String message, int dataLength) {
        super(message);
        this.dataLength = dataLength;
    }


}
