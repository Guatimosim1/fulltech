package com.capgemini.panteranegra.controllers;

import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.models.SessionPostInputDTO;
import com.capgemini.panteranegra.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sessoes")
public class SessionController {

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
    public String createSession(Model model, SessionPostInputDTO session) {
        return sessionService.createSession(model, session);
    }

    @GetMapping("/atualizar/{id}")
    public ModelAndView updateSession(@PathVariable("id") Long id) {
        return sessionService.updateSession(id);
    }

    @PostMapping("/atualizar")
    public String updateSession(Model model, Session session) {
        return sessionService.updateSession(model, session);
    }

    @GetMapping("/deletar/{id}")
    public String deleteSession(@PathVariable("id") Long id, Model model) {
        return sessionService.deleteSession(id, model);
    }

}
