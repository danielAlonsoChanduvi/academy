package com.daniverse.academy.infraestructure.exceptionhandler;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
@Log4j2
public class ControllerExceptionHandler {


    @ExceptionHandler(value = {BussinesRequestException.class})
    public ResponseEntity<PayloadException> generateBussinesException(BussinesRequestException bsex) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        // 1 create payload containing exception details
        PayloadException payloadException = new PayloadException(bsex.getCodeBs(), bsex.getMessage(), badRequest);
        // 2 return response entity
        return new ResponseEntity<>(payloadException,badRequest);
    }

    // MethodArgumentNotValidException
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<PayloadException> generateValidationException(MethodArgumentNotValidException valex) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        String message = valex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(","));


        PayloadException payloadException = new PayloadException("VALEX", message,badRequest);

        return new ResponseEntity<>(payloadException, badRequest);

    }

}
