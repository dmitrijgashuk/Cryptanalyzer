package ua.com.javarush.dhashuk.javarush_project_1;

import org.junit.jupiter.api.Test;
import ua.com.javarush.dhashuk.javarush_project_1.encryptor.CesarEncryptor;

import static org.junit.jupiter.api.Assertions.*;

class CharEncryptorTest {

    private CesarEncryptor encryptor = new CesarEncryptor();

    @Test
    void encryptPositiveDisplacement() {
        encryptor.setDisplacement(1);
        char actual = encryptor.encrypt('а');
        char expected = 'б';
        assertEquals(expected, actual);
    }

    @Test
    void encryptNegativeDisplacement() {
        encryptor.setDisplacement(-2);//43
        char actual = encryptor.encrypt('в');
        char expected = 'а';
        assertEquals(expected, actual);
    }

    @Test
    void encryptPosytiveDisplacementONRound() {
        encryptor.setDisplacement(43);
        char actual = encryptor.encrypt('a');
        char expected = 'a';
        assertEquals(expected, actual);
    }

    @Test
    void encryptCapitalLetter() {
        encryptor.setDisplacement(3);
        char actual = encryptor.encrypt('А');
        char expected = 'Г';
        assertEquals(expected, actual);
    }

    @Test
    void encryptSmallLetterToCapitalLetter() {
        encryptor.setDisplacement(8);
        char actual = encryptor.encrypt('ь');
        char expected = 'Д';
        assertEquals(expected, actual);
    }

    @Test
    void encryptZeroElementDisplacement() {
        encryptor.setDisplacement(0);
        char actual = encryptor.encrypt('a');
        char expected = 'a';
        assertEquals(expected, actual);
    }

    @Test
    void decodePositiveDisplacement() {
        encryptor.setDisplacement(5);
        char actual = encryptor.decode('д');
        char expexted = ' ';
        assertEquals(expexted,actual);
    }

    @Test
    void decodeNegativeDisplacement() {
        encryptor.setDisplacement(-5);
        char actual = encryptor.decode('д');
        char expexted = 'и';
        assertEquals(expexted,actual);
    }

    @Test
    void decodeCapitalLetter() {
        encryptor.setDisplacement(3);
        char actual = encryptor.decode('Г');
        char expected = 'А';
        assertEquals(expected, actual);
    }

    @Test
    void decodeCapitalLetterToSmallLetter() {
        encryptor.setDisplacement(4);
        char actual = encryptor.decode('Г');
        char expected = 'я';
        assertEquals(expected, actual);
    }
}