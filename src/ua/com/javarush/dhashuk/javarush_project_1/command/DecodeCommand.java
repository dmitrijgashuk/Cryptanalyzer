package ua.com.javarush.dhashuk.javarush_project_1.command;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class DecodeCommand extends Command{

    public DecodeCommand(String[] args) {
        super(args);
    }

    @Override
    public void execute() {
        decode(arguments);
    }

    private void decode(String[] args) {
        if("-decode".equals(args[0])) {
            if (args.length != 4) {
                System.err.println("Invalid command line: parameters less or more then four " + Arrays.toString(args));
            }
            String inputEncryptedFile = args[1];

            Path pathInputFile = Path.of(inputEncryptedFile);

            if(Files.notExists(pathInputFile)){
                System.err.println("Error, file " + inputEncryptedFile + "not exist");
                System.exit(1);
            }

            var isTxtFile = pathInputFile.getFileName().endsWith(".txt");
            if(!isTxtFile){
                System.err.println("File "+ inputEncryptedFile + " is not .txt file");
                System.exit(1);
            }

            String outputDecodeFile = args[2];

            String cesarKey = args[3];
            int key = 0;
            try{
                key = Integer.parseInt(cesarKey);
            } catch (NumberFormatException e) {
                System.err.println("You enter invalid key, key have to positive or negative integer number");
                System.exit(1);
            }
            // ??? Базовая логика обработки фалов и разкодированием текста
        }
    }


}
