package com.capgemini.panteranegra.exceptions.handler;

import com.capgemini.panteranegra.exceptions.PanteraException;
import com.capgemini.panteranegra.exceptions.RestPanteraException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@ControllerAdvice
public class PanteraHandler {
    @ExceptionHandler(PanteraException.class)
    public ModelAndView handlePanteraException(HttpServletRequest http, PanteraException exception) {
        return new ModelAndView("erro", "exception", exception.path(http.getRequestURI()));
    }

    @ExceptionHandler(RestPanteraException.class)
    public Details handleRestPanteraException(HttpServletRequest http, RestPanteraException exception) {
        return new Details().builder()
                .codigo(exception.getHttpStatus().value())
                .mensagem(exception.getMessage())
                .path(http.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
