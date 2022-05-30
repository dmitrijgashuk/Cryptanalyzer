package ua.com.javarush.dhashuk.javarush_project_1.encryptor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
    private CesarEncryptor encryptor;
    private Path inputFile;
    private Path outputFile;
    private List<String> outputStrings;
    private List<String> inputStrings;
    private int displacement;

    public FileProcessor(String[] args) {
        init(args);
    }

    public void setCesarKey(int key){
        this.displacement = key;
    }

    public int getCesarKey(){
        return displacement;
    }

    public void encryptFile() {
        outputStrings.clear();
        encryptor.setDisplacement(displacement);
        for (String input : inputStrings) {

            String encryptString = encryptor.encryptString(input);
            outputStrings.add(encryptString);
        }
    }

    public void decodeFile(int key) {
        outputStrings.clear();
        encryptor.setDisplacement(key);
        for (String input : inputStrings) {
            String encryptString = encryptor.decodeString(input);
            outputStrings.add(encryptString);
        }
    }

    public void decodeFile(){
        outputStrings.clear();
        encryptor.setDisplacement(displacement);
        for (String input : inputStrings) {
            String encryptString = encryptor.decodeString(input);
            outputStrings.add(encryptString);
        }
    }

    public void readFile() {
        try {
            inputStrings = Files.readAllLines(inputFile);
        } catch (IOException ex) {
            throw new FileProcessorException("Error: can not read file " + inputFile);
        }
    }

    public void writeFile() {
        try {
            Files.write(outputFile, outputStrings);
        } catch (IOException e) {
            throw new FileProcessorException("Error: can not write to file " + outputFile);
        }
    }

    public List<String> getInputStrings() {
        return inputStrings;
    }

    public List<String> getOutputStrings() {
        return outputStrings;
    }

    private void init(String[] args) {
        inputFile = Path.of(args[1]);
        outputFile = Path.of(args[2]);
        if(args.length>3) {
            displacement = Integer.parseInt(args[3]);
        }
        outputStrings = new ArrayList<>();
        encryptor = new CesarEncryptor();
    }
}
