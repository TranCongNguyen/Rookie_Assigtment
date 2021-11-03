package com.rookie.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryIdNotFound extends Exception{
    public CategoryIdNotFound(String message){
        super(message);
    }
}
