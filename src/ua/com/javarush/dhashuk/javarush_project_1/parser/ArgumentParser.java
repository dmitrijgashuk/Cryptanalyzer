package ua.com.javarush.dhashuk.javarush_project_1.parser;

import ua.com.javarush.dhashuk.javarush_project_1.command.Command;
import ua.com.javarush.dhashuk.javarush_project_1.command.HelpCommand;

public class ArgumentParser {

    private static final String NO_ARGUMENT_MESSAGE = "No arguments, you have to write parameter with paths " +
            "to files and cipher key, you should read '-help'";

    private final String[] commandLineArguments;

    public ArgumentParser(String[] arguments) {
        commandLineArguments = arguments;
    }

    public Command getCommand(){

        if(commandLineArguments.length<1){
            throw new WrongArgumentException(NO_ARGUMENT_MESSAGE);
        }


        if("-help".equals(commandLineArguments[0])){
            return new HelpCommand(commandLineArguments);
        }

        return null;
    }

}
