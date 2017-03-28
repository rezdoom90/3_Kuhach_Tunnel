package by.epam.tunnel.exception;

/**
 * Created by Антон on 12.03.2017.
 */
public class MissingFileException extends Exception {
    public MissingFileException() {
    }

    public MissingFileException(String message) {
        super(message);
    }

    public MissingFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingFileException(Throwable cause) {
        super(cause);
    }

    @Override
    public void printStackTrace() {
        System.err.println("File can't be found!");
    }
}
