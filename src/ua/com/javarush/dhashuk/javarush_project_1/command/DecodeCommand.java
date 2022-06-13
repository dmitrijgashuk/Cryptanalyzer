package ua.com.javarush.dhashuk.javarush_project_1.command;

import ua.com.javarush.dhashuk.javarush_project_1.encryptor.FileProcessor;

public class DecodeCommand extends Command {

    public DecodeCommand(String[] args) {
        super(args);
    }

    @Override
    public void execute() {
        FileProcessor decode = new FileProcessor(arguments);
        decode.readFile();
        decode.decodeFile();
        decode.writeFile();
    }

}
