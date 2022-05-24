package ua.com.javarush.dhashuk.javarush_project_1.parser;

import ua.com.javarush.dhashuk.javarush_project_1.command.Command;
import ua.com.javarush.dhashuk.javarush_project_1.command.CommandArgumentException;
import ua.com.javarush.dhashuk.javarush_project_1.command.HelpCommand;

public class ArgumentParser {
    private String[] commandLineArguments;

    public ArgumentParser(String[] arguments) {
        commandLineArguments = arguments;
    }

    public Command getCommand(){
        if(commandLineArguments.length<1){
            System.err.println("You have to write parameter with paths " +
                    "to files and cipher key, you should read '-help'");
            throw new CommandArgumentException("invalid parametr");
        }
        if("-help".equals(commandLineArguments[0])){
            return new HelpCommand(commandLineArguments);
        }

        return null;
    }
}
