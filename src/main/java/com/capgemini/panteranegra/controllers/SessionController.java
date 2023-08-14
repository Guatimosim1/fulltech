package com.capgemini.panteranegra.controllers;

import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.models.SessionPostInputDTO;
import com.capgemini.panteranegra.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sessoes")
public class SessionController {

    @Autowired
    private final SessionService sessionService;

    @GetMapping
    public ModelAndView listAllSessions() {
        return sessionService.listAllSessions();
    }

    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable("id") Long id) {
        return sessionService.findById(id);
    }

    @GetMapping("/criar-sessao")
    public ModelAndView createSession() {
        return sessionService.createSession();
    }

    @PostMapping("/criar-sessao")
    public String createSession(SessionPostInputDTO session) {
        return sessionService.createSession(session);
    }

    @GetMapping("/atualizar/{id}")
    public ModelAndView updateSession(@PathVariable("id") Long id) {
        return sessionService.updateSession(id);
    }

    @PostMapping("/atualizar")
    public String updateSession(Session session) {
        return sessionService.updateSession(session);
    }

    @GetMapping("/deletar/{id}")
    public String deleteSession(@PathVariable("id") Long id) {
        return sessionService.deleteSession(id);
    }

}
