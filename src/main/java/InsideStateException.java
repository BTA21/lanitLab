public class InsideStateException extends Exception {

    public InsideStateException() {

    }

    public InsideStateException(String message) {
        super(message);
    }

    public InsideStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsideStateException(Throwable cause) {
        super(cause);
    }

    protected InsideStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
