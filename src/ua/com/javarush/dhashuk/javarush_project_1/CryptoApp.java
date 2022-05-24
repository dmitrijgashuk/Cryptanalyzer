package ua.com.javarush.dhashuk.javarush_project_1;

import ua.com.javarush.dhashuk.javarush_project_1.command.Command;
import ua.com.javarush.dhashuk.javarush_project_1.parser.ArgumentParser;
import ua.com.javarush.dhashuk.javarush_project_1.processor.CommandHandler;

public class CryptoApp {
    public static void main(String[] args) {
        //todo добавить пользовательский интерфейс!!!
        // работа з файлами (создание, обработка)
        // вывод сообщений для пользователя
        // todo создать обработчик командной строки скитывание имен файлов размера сдига и имени исходящего файла

        ArgumentParser argumentParser = new ArgumentParser(args);
        Command argumentLineCommand = argumentParser.getCommand();

        CommandHandler handler = new CommandHandler();
        handler.setCommand(argumentLineCommand);
        handler.execute();
    }





}
