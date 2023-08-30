package com.capgemini.panteranegra.restapi.restcontroller;

import com.capgemini.panteranegra.entities.Chair;
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

    @CrossOrigin
    @GetMapping("/{id}")
    public Chair findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @CrossOrigin
    @GetMapping
    public List<Chair> findAll() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/session/{id}")
    public List<Chair> findBySessionId(@PathVariable("id") Long id) {
        return service.findBySessionId(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Chair assignChairToCustomer(@RequestBody CustomerNameInputDTO customerName, @PathVariable("id") Long id) {
        return service.assignChairToCustomer(customerName, id);
    }

}
