package ua.com.javarush.dhashuk.javarush_project_1.command;

public class NotACommand extends Command{
    public NotACommand(String[] args) {
        super(args);
    }

    @Override
    public void execute() {
        System.err.println(arguments[0] + " is not a command, you should read '-help'");
    }
}
