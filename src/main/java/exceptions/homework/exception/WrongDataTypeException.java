package exceptions.homework.exception;

public class WrongDataTypeException extends WrongInputException{
    private String dataName;
    public WrongDataTypeException(String message, String dataName) {
        super(message);
        this.dataName = dataName;
    }

    public String getDataName() {
        return dataName;
    }
}
