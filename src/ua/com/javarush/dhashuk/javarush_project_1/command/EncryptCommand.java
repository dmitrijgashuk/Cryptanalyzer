package ua.com.javarush.dhashuk.javarush_project_1.command;

import ua.com.javarush.dhashuk.javarush_project_1.encryptor.CharEncryptor;

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
        String stringFileName = args[1];
        Path inputPath = Path.of(stringFileName);

        String outputEncryptFile = args[2];

        int cesarKey = Integer.parseInt(args[3]);

        Path outputPath = Path.of(outputEncryptFile);

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardOpenOption.WRITE)
        ) {
            CharEncryptor encryptor = new CharEncryptor();
            encryptor.setDisplacement(cesarKey);
            while (reader.ready()) {
                String s = reader.readLine();
                char[] chars = s.toCharArray();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    char encrypt = encryptor.encrypt(chars[i]);
                    builder.append(encrypt);
                }
                builder.append('\n');
                writer.write(builder.toString());
            }
        } catch (IOException e) {
            System.err.println("Can't be read or write");
        }
    }
}
