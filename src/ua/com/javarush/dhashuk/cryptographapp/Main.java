package ua.com.javarush.dhashuk.cryptographapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CharEncryptor encryptor = new CharEncryptor(3);
        String line = "";

        while (!(line = scanner.nextLine()).equals("esc")){
            char[] chars = line.toCharArray();
            for (char ch: chars) {
                char encryptChar = encryptor.decode(ch);
                System.out.print(encryptChar);
            }
            System.out.println("");
        }
    }
}
