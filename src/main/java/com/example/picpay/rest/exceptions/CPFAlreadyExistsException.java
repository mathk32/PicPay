package com.example.picpay.rest.exceptions;

public class CPFAlreadyExistsException extends RuntimeException{
    public CPFAlreadyExistsException(String message){
        super(message);
    }
}
