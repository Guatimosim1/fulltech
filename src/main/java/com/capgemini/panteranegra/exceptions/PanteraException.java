package com.capgemini.panteranegra.exceptions;

import org.springframework.http.HttpStatus;

public class PanteraException extends RuntimeException {
    protected String msg;
    protected HttpStatus statusCode;

    public PanteraException(String msg, HttpStatus statusCode) {
        super(msg);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {return this.statusCode;}
}
