package Week7.RentACar.business.Exceptions;

public class DatabaseException extends Exception {
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}