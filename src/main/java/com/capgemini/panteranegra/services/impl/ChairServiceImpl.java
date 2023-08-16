package com.capgemini.panteranegra.services.impl;

import com.capgemini.panteranegra.entities.Chair;
import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.exceptions.PanteraException;
import com.capgemini.panteranegra.repositores.ChairRepository;
import com.capgemini.panteranegra.repositores.SessionRepository;
import com.capgemini.panteranegra.services.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class ChairServiceImpl implements ChairService {

    @Autowired
    private ChairRepository chairRepository;
    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public ModelAndView findById(Long id) {
        try {
            Chair chair = chairRepository.findById(id).orElseThrow(() -> new PanteraException(String.format("Cadeira com id %d não foi encontrada", id), HttpStatus.NOT_FOUND));
            return new ModelAndView("cadeira", "chair", chair);
        } catch (PanteraException exception) {
            return new ModelAndView("erro", "exception", exception);
        }
    }

    @Override
    public ModelAndView findBySession(Long idSessao) {
        Session session = sessionRepository.findById(idSessao).orElseThrow(() -> new PanteraException(String.format("Sessão com id %d não foi encontrada", idSessao), HttpStatus.NOT_FOUND));
        List<Chair> chairs = chairRepository.findBySession(session);
        return new ModelAndView("cadeiras_sessao", "cadeiras", chairs);
    }

    @Override
    public ModelAndView findByCustomerName(String nomeCliente) {
        try {
            Chair chair = chairRepository.findByCostumerName(nomeCliente).orElseThrow(() -> new PanteraException(String.format("Não existem cadeiras assinaladas para o cliente: %s", nomeCliente), HttpStatus.NOT_FOUND));
            return new ModelAndView("cadeira", "chair", chair);
        } catch (PanteraException exception) {
            return new ModelAndView("erro", "exception", exception);
        }
    }

    @Override
    public ModelAndView assignChairToCustomer(Long id, String nomeCliente) {
        try {
            Chair chair = chairRepository.findById(id).orElseThrow(() -> new PanteraException(String.format("Cadeira com id %d não foi encontrada", id), HttpStatus.NOT_FOUND));
            if(chair.getStatus()) throw new PanteraException("Esta cadeira já está assinalada a outro cliente", HttpStatus.BAD_REQUEST);
            chair.setCostumerName(nomeCliente); chair.setStatus(true);
            Chair saved = chairRepository.save(chair);
            return new ModelAndView("cadeira", "chair", saved);
        } catch (PanteraException exception) {
            return new ModelAndView("erro", "exception", exception);
        }
    }

}
