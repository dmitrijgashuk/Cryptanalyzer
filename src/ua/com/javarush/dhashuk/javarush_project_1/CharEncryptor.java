package ua.com.javarush.dhashuk.javarush_project_1;

public class CharEncryptor {
    private final char[] RU_ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э',
            'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    private int displacement;

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

    public int getDisplacement() {
        return displacement;
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
        return getAlphabetCharIndex(originalChar)!=-1;
    }

}
