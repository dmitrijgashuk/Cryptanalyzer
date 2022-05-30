package ua.com.javarush.dhashuk.javarush_project_1.command;

import ua.com.javarush.dhashuk.javarush_project_1.encryptor.FileProcessor;

public class EncryptCommand extends Command {

    public EncryptCommand(String[] args) {
        super(args);
    }

    @Override
    public void execute() {
        FileProcessor encrypt = new FileProcessor(arguments);
        encrypt.readFile();
        encrypt.encryptFile();
        encrypt.writeFile();
    }
}
