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
            return new ModelAndView("session/listaSessao", "sessionList", retorno);
        } catch (Exception e) {
            throw new PanteraException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ModelAndView findById(Long id) {
        Session session = sessionRepository.findById(id).orElseThrow(() -> new PanteraException(String.format("Sessão com id %s não foi encontrada", id), HttpStatus.NOT_FOUND));
        return new ModelAndView("sessao", "sessao", session);
    }

    @Override
    public ModelAndView createSession() {
        try{
            return new ModelAndView("session/criarSessao");
        } catch (Exception exception) {
            throw new PanteraException(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ModelAndView createSession(SessionPostInputDTO session) {
        try{
            sessionRepository.save(SessionFactory.toEntity(session));
            System.out.println("Foi salvo");
            return new ModelAndView("session/listaSessao");
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new PanteraException(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ModelAndView updateSession(Long id) {
        try{
            Session session = sessionRepository.findById(id).orElseThrow(() -> new PanteraException("Sessão com id " + id + "não foi encontrada", HttpStatus.NOT_FOUND));
            return new ModelAndView("atualizarSessao", "sessao", session);
        } catch (Exception exception) {
            throw new PanteraException(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public String updateSession(Session session) {
        try{
            sessionRepository.save(session);
            return "redirect:listaSessao";
        } catch (Exception exception) {
            throw new PanteraException(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public String deleteSession(Long id) {
        Session session = sessionRepository.findById(id).orElseThrow(() -> new PanteraException("A sessão com id " + id + " não foi encontrada", HttpStatus.NOT_FOUND));
        sessionRepository.delete(session);
        return "redirect:listaSessao";
    }
}
