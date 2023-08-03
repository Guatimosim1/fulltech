package com.capgemini.panteranegra.controllers;

import com.capgemini.panteranegra.models.SessionPostOutputDTO;
import com.capgemini.panteranegra.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sessoes")
public class SessionController {

    private final SessionService sessionService;

    @GetMapping
    public ResponseEntity<List<SessionPostOutputDTO>> listAllSessions() {
        return ResponseEntity.ok(sessionService.listAllSessions());
    }

}
