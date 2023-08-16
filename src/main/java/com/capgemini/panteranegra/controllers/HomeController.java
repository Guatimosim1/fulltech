package com.capgemini.panteranegra.controllers;

import com.capgemini.panteranegra.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private SessionService service;

	@GetMapping("/")
	public ModelAndView iniciar() {
		return service.listAllSessions();
	}
	
}
