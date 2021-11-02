package com.rookie.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductDetailNotExistException extends Exception{
    public ProductDetailNotExistException(String message){
        super(message);
    }
}
