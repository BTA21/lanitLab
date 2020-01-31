public class ItemStoreExeption extends Exception{

    public ItemStoreExeption() {
    }

    public ItemStoreExeption(String message) {
        super(message);
    }

    public ItemStoreExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemStoreExeption(Throwable cause) {
        super(cause);
    }

    public ItemStoreExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
