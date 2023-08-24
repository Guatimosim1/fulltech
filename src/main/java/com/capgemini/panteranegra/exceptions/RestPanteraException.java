package com.capgemini.panteranegra.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestPanteraException extends RuntimeException {
    private HttpStatus httpStatus;
    public RestPanteraException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
    public RestPanteraException httpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus; return this;
    }
}
