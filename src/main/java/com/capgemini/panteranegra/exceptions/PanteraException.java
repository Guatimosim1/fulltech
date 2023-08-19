package com.capgemini.panteranegra.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PanteraException extends RuntimeException {
    protected String msg;
    protected HttpStatus statusCode;
    protected String path;
    protected String timestamp;

    public PanteraException(String msg, HttpStatus statusCode) {
        super(msg);
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public HttpStatus getStatusCode() {return this.statusCode;}
    public String getPath() {return this.path;}
    public String getTimestamp() {return this.timestamp;}
    public PanteraException path(String path) {this.path = path; return this;}
}
