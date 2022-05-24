package ua.com.javarush.dhashuk.javarush_project_1.processor;

import ua.com.javarush.dhashuk.javarush_project_1.command.Command;

public class CommandHandler {

    private Command executeCommand;

    public void setCommand(Command command) {
        this.executeCommand = command;
    }

    public void execute() {
        executeCommand.execute();
    }
}
