package com.example.picpay.rest.exceptions;

import java.util.List;

public class UserAlreadyExistsException extends  RuntimeException{

    private final List<String> messages;

    public UserAlreadyExistsException(List<String> messages){
        super(String.join(", ", messages));
        this.messages = messages;
    }

    public List<String> getMessages(){
        return messages;
    }

}
