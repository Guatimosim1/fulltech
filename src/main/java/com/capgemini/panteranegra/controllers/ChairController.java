package com.capgemini.panteranegra.controllers;

import com.capgemini.panteranegra.models.CustomerNameInputDTO;
import com.capgemini.panteranegra.services.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/cadeiras")
public class ChairController {
    @Autowired
    private ChairService service;

    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping("/list/{idSessao}")
    public ModelAndView findBySession(@PathVariable("idSessao") Long idSessao) {
        return service.findBySession(idSessao);
    }

    @PostMapping("")
    public ModelAndView findByCustumerName(@RequestBody CustomerNameInputDTO cliente) {
        return service.findByCustomerName(cliente.getNomeCliente());
    }

    @GetMapping("/assign/{id}")
    public ModelAndView assignChairToCustomer(@PathVariable("id") Long id, CustomerNameInputDTO cliente) {
        return service.assignChairToCustomer(id, cliente.getNomeCliente());
    }
}
