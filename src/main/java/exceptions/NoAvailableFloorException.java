package exceptions;

public class NoAvailableFloorException extends Exception {
    public NoAvailableFloorException(String message) {
        super(message);
    }

    public NoAvailableFloorException(String message, Throwable cause) {
        super(message, cause);
    }
}
