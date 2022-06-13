package ua.com.javarush.dhashuk.javarush_project_1.encryptor;

public class FileProcessorException extends RuntimeException{
    FileProcessorException(){

    }

    FileProcessorException(String message){
        super(message);
    }

    FileProcessorException(String message, Throwable throwable){

    }
}
