package com.dobreadrianaliatema6.dobreadrianaliatema6.exception;

public class NoPatientException extends Exception{
    public NoPatientException(){
        super("The patient does not exist.");
    }
}
