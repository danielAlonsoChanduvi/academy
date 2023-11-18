package com.daniverse.academy.infraestructure.exceptionhandler;

import org.springframework.http.HttpStatus;

public class PayloadException {

    private final String businessCode;
    private final String message;
    private final HttpStatus httpStatus;

    public PayloadException(String businessCode, String message, HttpStatus httpStatus) {
        this.businessCode = businessCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
