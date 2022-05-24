package ua.com.javarush.dhashuk.javarush_project_1.command;

import ua.com.javarush.dhashuk.javarush_project_1.encryptors.CharEncryptor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class EncryptCommand extends Command {

    public EncryptCommand(String[] args) {
        super(args);
    }

    @Override
    public void execute() {
        encrypt(arguments);
    }

    private static void encrypt(String[] args) {

            String inputFile = args[1];
            Path inputFilePath = Path.of(inputFile);

            String outputEncryptFile = args[2];

            String cesarKey = args[3];

            Path outputFilePath = Path.of(outputEncryptFile);

            try (BufferedReader reader = Files.newBufferedReader(inputFilePath);
                 BufferedWriter writer = Files.newBufferedWriter(outputFilePath, StandardOpenOption.WRITE);
            ) {
                CharEncryptor encryptor = new CharEncryptor();
                encryptor.setDisplacement(Integer.parseInt(cesarKey));
                while (reader.ready()) {
                    String s = reader.readLine();
                    char[] chars = s.toCharArray();
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < s.length() ; i++) {
                        char encrypt = encryptor.encrypt(chars[i]);
                        builder.append(encrypt);
                    }
                    builder.append('\n');
                    writer.write(builder.toString());

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
