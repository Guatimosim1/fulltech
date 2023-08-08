package com.capgemini.panteranegra.services;

import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.models.SessionPostInputDTO;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface SessionService {
    ModelAndView listAllSessions();

    ModelAndView findById(Long id);

    ModelAndView createSession();

    String createSession(Model model, SessionPostInputDTO session);

    ModelAndView updateSession(Long id);

    String updateSession(Model model, Session session);

    String deleteSession(Long id, Model model);
}
