package ua.com.javarush.dhashuk.javarush_project_1;

public class CharEncryptor {
    private final char[] RU_ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э',
            'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    private int displacement;

    public CharEncryptor(int displacement) {
        this.displacement = displacement;
    }

    public char encrypt(char originalChar) {
        /* todo придумать новое название для переменной alphabetIndex,
        *   учесть что ключь может быть отрицательным? логика в методах одинаковая вывести в один метод!! */
        if (isCharExistInAlphabet(originalChar)){
            int alphabetCharIndex = getAlphabetCharIndex(originalChar);
            int newCharIndex = (alphabetCharIndex + (displacement + RU_ALPHABET.length)) % RU_ALPHABET.length;
            return RU_ALPHABET[newCharIndex];
        }
        return originalChar;
    }

    public char decode(char cipherChar) {// todo метод работает неправильно, учесть что ключ может быть отрецательным
        if (isCharExistInAlphabet(cipherChar)) {
            int index = getAlphabetCharIndex(cipherChar);
            int codeLetterIndex = (index + (-displacement + RU_ALPHABET.length)) % RU_ALPHABET.length;
            return RU_ALPHABET[codeLetterIndex];
        }
        return cipherChar;
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
