package com.capgemini.panteranegra.services.impl;

import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.exceptions.PanteraException;
import com.capgemini.panteranegra.factory.SessionFactory;
import com.capgemini.panteranegra.mappers.ProjectMapper;
import com.capgemini.panteranegra.models.SessionPostInputDTO;
import com.capgemini.panteranegra.models.SessionPostOutputDTO;
import com.capgemini.panteranegra.repositores.SessionRepository;
import com.capgemini.panteranegra.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ModelAndView listAllSessions() {
        try {
            List<SessionPostOutputDTO> retorno = sessionRepository.findAll().stream().map(projectMapper::sessionEntityToPostOutputDto).toList();
            return new ModelAndView("listaSessao", "sessionList", retorno);
        } catch (Exception e) {
            return new ModelAndView("erro", "msg_erro", e.getMessage());
        }

    }

    @Override
    public ModelAndView findById(Long id) {
        try {
            Session session = sessionRepository.findById(id).orElseThrow(() -> new PanteraException(String.format("Sessão com id %s não foi encontrada", id), HttpStatus.NOT_FOUND));
            return new ModelAndView("sessao", "sessao", session);
        } catch (PanteraException exception) {
            return new ModelAndView("erro", "exception", exception);
        }
    }

    @Override
    public ModelAndView createSession() {
        try{
            return new ModelAndView("criarSessao");
        } catch (Exception exception) {
            return new ModelAndView("erro", "msg_erro", exception.getMessage());
        }
    }

    @Override
    public String createSession(Model model, SessionPostInputDTO session) {
        try{
            sessionRepository.save(SessionFactory.toEntity(session));
            return "redirect:listaSessao";
        } catch (Exception exception) {
            model.addAttribute("msg_erro", exception.getMessage());
            return "erro";
        }
    }

    @Override
    public ModelAndView updateSession(Long id) {
        try{
            Session session = sessionRepository.findById(id).orElseThrow(() -> new PanteraException("Sessão com id " + id + "não foi encontrada", HttpStatus.NOT_FOUND));
            return new ModelAndView("atualizarSessao", "sessao", session);
        } catch (PanteraException exception) {
            return new ModelAndView("erro", "exception", exception);
        }
    }

    @Override
    public String updateSession(Model model, Session session) {
        try{
            sessionRepository.save(session);
            return "redirect:listaSessao";
        } catch (Exception exception) {
            model.addAttribute("msg_erro", exception.getMessage());
            return "erro";
        }
    }

    @Override
    public String deleteSession(Long id, Model model) {
        try{
            Session session = sessionRepository.findById(id).orElseThrow(() -> new PanteraException("A sessão com id " + id + " não foi encontrada", HttpStatus.NOT_FOUND));
            sessionRepository.delete(session);
        } catch (PanteraException exception) {
            model.addAttribute("exception", exception);
        }
        return "redirect:listaSessao";
    }
}
