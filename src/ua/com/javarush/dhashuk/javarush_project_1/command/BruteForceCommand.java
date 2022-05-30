package ua.com.javarush.dhashuk.javarush_project_1.command;

import ua.com.javarush.dhashuk.javarush_project_1.encryptor.FileProcessor;
import ua.com.javarush.dhashuk.javarush_project_1.encryptor.HackCesarCipher;

public class BruteForceCommand extends Command {

    public BruteForceCommand(String[] lineArguments) {
        super(lineArguments);
    }

    @Override
    public void execute() {
        bruteForce();
    }

    private void bruteForce(){
        FileProcessor fileProcessor = new FileProcessor(arguments);
        HackCesarCipher hackCesarCipher =  new HackCesarCipher(fileProcessor);
        hackCesarCipher.Hack();
    }
}
