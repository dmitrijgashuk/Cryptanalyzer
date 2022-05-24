package ua.com.javarush.dhashuk.javarush_project_1.command;

public class HelpCommand extends Command {

    public HelpCommand(String[] args) {
        super(args);
    }

    @Override
    public void execute() {
        printMessage();
    }

    private static void printMessage() {
        System.out.println("if you want to cipher text in the file use :");
        System.out.println("[-encrypt] [name existing text file (.txt)] [name output cipher file path " +
                "(.txt)] [cipher key (positive or negative integer number)]");
        System.out.println("");
        System.out.println("if you want to decode text in the file use :");
        System.out.println("[-decode] [name existing ciphered text file (.txt)] [name output file path " +
                "(.txt)] [cipher key (positive or negative integer number)]");
    }
}
