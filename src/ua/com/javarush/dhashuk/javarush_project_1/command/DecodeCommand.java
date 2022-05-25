package ua.com.javarush.dhashuk.javarush_project_1.command;

import ua.com.javarush.dhashuk.javarush_project_1.encryptor.CharEncryptor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class DecodeCommand extends Command {

    public DecodeCommand(String[] args) {
        super(args);
    }

    @Override
    public void execute() {
        decode(arguments);
    }

    private void decode(String[] args) {

        String inputFileName = args[1];

        Path inputPath = Path.of(inputFileName);

        String outputDecodeFileName = args[2];

        int cesarKey = Integer.parseInt(args[3]);

        Path outputPath = Path.of(outputDecodeFileName);
// разница с в кодировании и декодировании толко в вызове одного метода
        // нужно добавить клас обработки файлов и способ кодирования
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
                    char encrypt = encryptor.decode(chars[i]);
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
