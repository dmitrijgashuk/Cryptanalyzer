package ua.com.javarush.dhashuk.javarush_project_1.command;

public class CommandArgumentException extends RuntimeException {
    public CommandArgumentException() {

    }

    public CommandArgumentException(String message) {
        super(message);
    }

    public CommandArgumentException(String message, Throwable cause) {
        super(message,cause);
    }
}
