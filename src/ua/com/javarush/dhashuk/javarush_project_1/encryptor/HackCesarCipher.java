package ua.com.javarush.dhashuk.javarush_project_1.encryptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HackCesarCipher {
    public static final List<String> words = Arrays.asList(new String[]{" и "," в "," не "," на "," я "," быть "," с "," он ",
            " что "," а "," этот "," это "," по "," но "," они "," мы "," то "," у "," из "," за "," от "," так "," ты ",
            " или "," если "," ещё "," уже "});

    private FileProcessor fileProcessor;
    private Map<Integer,Integer> keyFrequency = new HashMap<>();

    public HackCesarCipher(FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
    }

    public void Hack(){
        fileProcessor.readFile();

        for (int i = 1; i< CesarEncryptor.RU_ALPHABET.length;i++) {
            fileProcessor.decodeFile(i);
            List<String> decodeContent = fileProcessor.getOutputStrings();
            int frequency = getFrequency(decodeContent);
            keyFrequency.put(i,frequency);
        }
        int keyWithMaxFrequency = getKeyWithMaxFrequency();

        fileProcessor.decodeFile(keyWithMaxFrequency);

        fileProcessor.writeFile();
    }

    private int getKeyWithMaxFrequency() {
        int max = 0;
        int keyWithMaxFrequency=0;
        for(var buket: keyFrequency.entrySet()){
            if(max<buket.getValue()){
                max = buket.getValue();
                keyWithMaxFrequency = buket.getKey();
            }
        }
        return keyWithMaxFrequency;
    }

    private int getFrequency(List<String> decodeContent) {
        int frequency = 0;
        for (String fileLine : decodeContent) {
            for (int j = 0; j < words.size(); j++) {
                boolean contains = fileLine.contains(words.get(j));
                if(contains){
                    frequency++;
                }
            }
        }
        return frequency;
    }
}
