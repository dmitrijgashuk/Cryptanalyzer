package ua.com.javarush.dhashuk.cryptographapp;

public class CharEncryptor {
    private final char[] RU_ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э',
            'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    private int displacement;

    public CharEncryptor(int displacement) {
        this.displacement = displacement;
    }

    public char encrypt(char originalChar) {
        int index = getCharAlphabetIndex(originalChar);
        /* todo придумать новое название для переменной index */
        if (index != -1) {
            int codeLetterIndex = (index + displacement) % RU_ALPHABET.length;
            return RU_ALPHABET[codeLetterIndex];
        }
        return originalChar;
    }

    public char decode(char cipherChar) {
        int index = getCharAlphabetIndex(cipherChar);

        if (index != -1) {
            int codeLetterIndex = (index - displacement) % RU_ALPHABET.length;
            return RU_ALPHABET[codeLetterIndex];
        }
        return cipherChar;
    }

    private int getCharAlphabetIndex(char letter) {
        for (int i = 0; i < RU_ALPHABET.length; i++) {
            if (RU_ALPHABET[i] == letter) {
                return i;
            }
        }
        return -1;
    }

}
