package com.capgemini.panteranegra.exceptions.handler;

import com.capgemini.panteranegra.exceptions.PanteraException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class PanteraHandler {
    @ExceptionHandler(PanteraException.class)
    public ModelAndView handlePanteraException(HttpServletRequest http, PanteraException exception) {
        return new ModelAndView("erro", "exception", exception.path(http.getRequestURI()));
    }
}
