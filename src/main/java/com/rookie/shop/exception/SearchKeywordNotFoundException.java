package com.rookie.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SearchKeywordNotFoundException extends Exception{
    public SearchKeywordNotFoundException(String message){
        super(message);
    }
}
