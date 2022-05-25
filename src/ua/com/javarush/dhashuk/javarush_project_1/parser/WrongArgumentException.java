package ua.com.javarush.dhashuk.javarush_project_1.parser;

public class WrongArgumentException extends RuntimeException {
    public WrongArgumentException() {

    }

    public WrongArgumentException(String message) {
        super(message);
    }

    public WrongArgumentException(String message, Throwable cause) {
        super(message,cause);
    }
}
