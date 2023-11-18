package com.daniverse.academy.infraestructure.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(value = {BussinesRequestException.class})
    public ResponseEntity<PayloadException> generateBussinesException(BussinesRequestException bsex) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        // 1 create payload containing exception details
        PayloadException payloadException = new PayloadException(bsex.getCodeBs(), bsex.getMessage(), badRequest);
        // 2 return response entity
        return new ResponseEntity<>(payloadException,badRequest);
    }

}
