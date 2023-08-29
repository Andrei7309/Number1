package services.exception;

public class ConnectionException extends RuntimeException {
    private String message;

    public ConnectionException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
