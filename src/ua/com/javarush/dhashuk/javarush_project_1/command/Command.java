package ua.com.javarush.dhashuk.javarush_project_1.command;

public abstract class Command {
    protected String[] arguments;

    public Command(String[] args){
        this.arguments = args;
    }

    public abstract void execute();
}
