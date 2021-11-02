package com.rookie.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class SaveErrorException extends Exception{
    public SaveErrorException(String message){
        super(message);
    }
}
