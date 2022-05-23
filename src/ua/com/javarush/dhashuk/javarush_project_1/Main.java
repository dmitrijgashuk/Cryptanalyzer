package ua.com.javarush.dhashuk.javarush_project_1;

import ua.com.javarush.dhashuk.javarush_project_1.encryptors.CharEncryptor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //todo добавить пользовательский интерфейс!!!
        // работа з файлами (создание, обработка)
        // вывод сообщений для пользователя

        if(args.length<1){
            System.err.println("You have to write parameter with paths " +
                    "to files and cipher key, you should read '-help'");
            System.exit(1);
        }

        if(args[0].equals("-help")&&args.length==1){
            System.out.println("if you want to cipher text in the file use :");
            System.out.println("[-encrypt] [name existing text file (.txt)] [name output cipher file path " +
                    "(.txt)] [cipher key (positive or negative integer number)]");
            System.out.println("");
            System.out.println("if you want to decode text in the file use :");
            System.out.println("[-decode] [name existing ciphered text file (.txt)] [name output file path " +
                    "(.txt)] [cipher key (positive or negative integer number)]");
        } else {
            System.err.println("Invalid parameters");
        }
        // КОДИРОВНИЕ
        if(args[0].equals("-encrypt")&&args.length==4){
            String inputFile = args[1];

            Path pathInputFile = Path.of(inputFile);

            if(Files.notExists(pathInputFile)){
                System.err.println("Error, file " + inputFile + "not exist");
                System.exit(1);
            }

            var isTxtFile = pathInputFile.getFileName().endsWith(".txt");
            if(!isTxtFile){
                System.err.println("File "+ inputFile + " is not .txt file");
                System.exit(1);
            }

            String outputEncryptFile = args[2];
            // ??? Базовая логика обработки фалов и кодированием их

            String cesarKey = args[3];
        }

        // ДЕКОДИРОВНИЕ
        if(args[0].equals("-decode")&&args.length==4){
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
            // ??? Базовая логика обработки фалов и разкодированием текста
            String cesarKey = args[3];
        }

        // todo создать обработчик командной строки скитывание имен файлов размера сдига и имени исходящего файла

        Path inputFilePath = Path.of("input.txt");
        Path outputFilePath = Path.of("output.txt");
        try {
            if(Files.notExists(outputFilePath)) {
                Files.createFile(outputFilePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = Files.newBufferedReader(inputFilePath);
             BufferedWriter writer = Files.newBufferedWriter(outputFilePath, StandardOpenOption.WRITE);
        ) {
            CharEncryptor encryptor = new CharEncryptor();
            encryptor.setDisplacement(2);
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
