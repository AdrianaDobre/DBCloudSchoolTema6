package com.dobreadrianaliatema6.dobreadrianaliatema6.exception;

public class NoDoctorException extends Exception{
    public NoDoctorException(){
        super("The doctor does not exist.");
    }
}
