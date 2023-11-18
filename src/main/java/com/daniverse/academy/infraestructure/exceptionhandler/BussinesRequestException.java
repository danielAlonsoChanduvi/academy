package com.daniverse.academy.infraestructure.exceptionhandler;

public class BussinesRequestException extends RuntimeException{

    private String codeBs;

    public BussinesRequestException(String codeBs, String message) {
        super(message);
        this.codeBs = codeBs;
    }

    public BussinesRequestException(String codeBs, String message, Throwable cause) {
        super(message, cause);
        this.codeBs = codeBs;

    }

    public String getCodeBs() {
        return this.codeBs;
    }
}
