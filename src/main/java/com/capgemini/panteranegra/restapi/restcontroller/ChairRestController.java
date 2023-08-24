package com.capgemini.panteranegra.restapi.restcontroller;

import com.capgemini.panteranegra.entities.Chair;
import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.models.CustomerNameInputDTO;
import com.capgemini.panteranegra.restapi.restservice.ChairRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chairs")
public class ChairRestController {

    @Autowired
    private ChairRestService service;

    @GetMapping("/{id}")
    public Chair findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Chair> findAll() {
        return service.findAll();
    }

    @GetMapping("/session/{id}")
    public List<Chair> findBySessionId(@PathVariable("id") Long id) {
        return service.findBySessionId(id);
    }

    @PutMapping("/{id}")
    public Chair assignChairToCustomer(@RequestBody CustomerNameInputDTO customerName, @PathVariable("id") Long id) {
        return service.assignChairToCustomer(customerName, id);
    }

}
