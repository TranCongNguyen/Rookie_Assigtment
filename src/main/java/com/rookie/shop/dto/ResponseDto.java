package com.rookie.shop.dto;

import java.time.LocalDateTime;

public class ResponseDto {

    private LocalDateTime time = LocalDateTime.now();
    private String errorCode;
    private Object data;
    private String successCode;

    public ResponseDto(LocalDateTime time, String errorCode, Object data, String successCode) {
        this.time = time;
        this.errorCode = errorCode;
        this.data = data;
        this.successCode = successCode;
    }
}
