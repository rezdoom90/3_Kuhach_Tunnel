package by.epam.tunnel.exception;

/**
 * Created by Антон on 12.03.2017.
 */
public class WrongInputException extends Exception {
    public WrongInputException() {
    }

    public WrongInputException(String message) {
        super(message);
    }

    public WrongInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongInputException(Throwable cause) {
        super(cause);
    }

    @Override
    public void printStackTrace() {
        System.err.println("Wrong data input!");
    }
}
