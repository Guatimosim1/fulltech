package com.capgemini.panteranegra.controllers;

import com.capgemini.panteranegra.exceptions.PanteraException;
import com.capgemini.panteranegra.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private SessionService service;

	@GetMapping("/")
	public ModelAndView iniciar() {
		ModelAndView model = new ModelAndView();
		return service.listAllSessions();
	}

	@GetMapping("/testar-exception")
	public void testarException() {
		throw new PanteraException("Isso foi um teste :)", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
