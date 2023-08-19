package com.capgemini.panteranegra.services;

import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.models.SessionPostInputDTO;
import org.springframework.web.servlet.ModelAndView;

public interface SessionService {
    ModelAndView listAllSessions();

    ModelAndView findById(Long id);

    ModelAndView createSession();

    ModelAndView createSession(SessionPostInputDTO session);

    ModelAndView updateSession(Long id);

    String updateSession(Session session);

    String deleteSession(Long id);
}
