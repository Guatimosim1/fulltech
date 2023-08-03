package com.capgemini.panteranegra.services;

import com.capgemini.panteranegra.models.SessionPostOutputDTO;

import java.util.List;

public interface SessionService {
    List<SessionPostOutputDTO> listAllSessions();
}
