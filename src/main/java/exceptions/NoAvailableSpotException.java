package exceptions;

public class NoAvailableSpotException extends Exception{
    public NoAvailableSpotException(String message) {
        super(message);
    }

    public NoAvailableSpotException(String message, Throwable cause) {
        super(message, cause);
    }
}
