package com.capgemini.panteranegra.services;

import com.capgemini.panteranegra.mappers.ProjectMapper;
import com.capgemini.panteranegra.models.SessionPostOutputDTO;
import com.capgemini.panteranegra.repositores.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final ProjectMapper projectMapper;

    @Override
    public List<SessionPostOutputDTO> listAllSessions() {
        return sessionRepository.findAll().stream().map(projectMapper::sessionEntityToPostOutputDto).toList();
    }
}
