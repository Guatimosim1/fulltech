package com.capgemini.panteranegra.restapi.restcontroller;

import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.models.SessionPostInputDTO;
import com.capgemini.panteranegra.restapi.restservice.SessionRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionRestController {

    @Autowired
    private SessionRestService service;

    @GetMapping("/{id}")
    public Session findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @CrossOrigin
    @GetMapping
    public List<Session> findAll() {
        return service.findAll();
    }

    @CrossOrigin
    @PostMapping
    public Session create(@RequestBody SessionPostInputDTO session) {
        return service.create(session);
    }

    @PutMapping("/{id}")
    public Session update(@RequestBody SessionPostInputDTO session, @PathVariable("id") Long id) {
        return service.update(session, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
