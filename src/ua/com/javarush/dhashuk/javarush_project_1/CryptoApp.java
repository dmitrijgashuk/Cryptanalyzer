package ua.com.javarush.dhashuk.javarush_project_1;

import ua.com.javarush.dhashuk.javarush_project_1.command.Command;
import ua.com.javarush.dhashuk.javarush_project_1.parser.ArgumentParser;
import ua.com.javarush.dhashuk.javarush_project_1.parser.WrongArgumentException;
import ua.com.javarush.dhashuk.javarush_project_1.processor.CommandHandler;

public class CryptoApp {
    public static void main(String[] args) {
        ArgumentParser argumentParser = new ArgumentParser(args);
        Command programCommand =  null;
        try {
            programCommand = argumentParser.getCommand();
        } catch (WrongArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        CommandHandler handler = new CommandHandler();
        handler.setCommand(programCommand);
        handler.execute();
    }





}
