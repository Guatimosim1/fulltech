package com.capgemini.panteranegra.services;

import org.springframework.web.servlet.ModelAndView;

public interface ChairService {
    ModelAndView findById(Long id);
    ModelAndView findBySession(Long idSessao);
    ModelAndView findByCustomerName(String nomeCliente);
    ModelAndView assignChairToCustomer(Long id, String nomeCliente);
}
