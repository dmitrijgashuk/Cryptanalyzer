package ua.com.javarush.dhashuk.javarush_project_1.encryptor;

public class CesarEncryptor {
    public static final char[] RU_ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э',
            'ю', 'я','А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П',
            'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ь', 'Э','Ю', 'Б', '.', ',', '«',
            '»', '"', '\'', ':', '!', '?', ' '};

    private int displacement;

    public String encryptString(String line){
        char[] chars = line.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            char encryptChar = encrypt(aChar);
            builder.append(encryptChar);
        }
        return builder.toString();
    }

    public String decodeString(String line){
        char[] chars = line.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            char decodeChar = decode(aChar);
            builder.append(decodeChar);
        }
        return builder.toString();
    }

    public char encrypt(char originalChar) {
        if (isCharExistInAlphabet(originalChar)){
            int cryptOffset = displacement;
            int newCharIndex = getNewCharIndex(originalChar,cryptOffset);
            return RU_ALPHABET[newCharIndex];
        }
        return originalChar;
    }

    public char decode(char cipherChar) {
        if (isCharExistInAlphabet(cipherChar)) {
            int decodeOffset = displacement*-1;
            int newCharIndex = getNewCharIndex(cipherChar,decodeOffset);
            return RU_ALPHABET[newCharIndex];
        }
        return cipherChar;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    private int getNewCharIndex(char letter,int offset) {
        int alphabetCharIndex = getAlphabetCharIndex(letter);
        return (alphabetCharIndex + (offset + RU_ALPHABET.length)) % RU_ALPHABET.length;
    }

    private int getAlphabetCharIndex(char letter) {
        for (int i = 0; i < RU_ALPHABET.length; i++) {
            if (RU_ALPHABET[i] == letter) {
                return i;
            }
        }
        return -1;
    }

    private boolean isCharExistInAlphabet(char originalChar){
        return getAlphabetCharIndex(originalChar)>-1;
    }

}
