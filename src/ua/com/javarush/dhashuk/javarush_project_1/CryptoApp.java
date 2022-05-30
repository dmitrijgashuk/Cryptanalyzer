package ua.com.javarush.dhashuk.javarush_project_1;

import ua.com.javarush.dhashuk.javarush_project_1.command.Command;
import ua.com.javarush.dhashuk.javarush_project_1.encryptor.FileProcessorException;
import ua.com.javarush.dhashuk.javarush_project_1.parser.CommandLineParser;
import ua.com.javarush.dhashuk.javarush_project_1.parser.WrongArgumentException;

public class CryptoApp {
    public static void main(String[] args) {
        CommandLineParser commandLineParser = new CommandLineParser(args);
        try {
            Command programCommand = commandLineParser.getCommand();
            programCommand.execute();
        } catch (WrongArgumentException | FileProcessorException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
