package com.capgemini.panteranegra.restapi.restservice;

import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.exceptions.RestPanteraException;
import com.capgemini.panteranegra.factory.SessionFactory;
import com.capgemini.panteranegra.models.SessionPostInputDTO;
import com.capgemini.panteranegra.repositores.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionRestService {
    @Autowired
    private SessionRepository repository;

    public Session findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RestPanteraException("Sessão com id "+id+" não foi encontrada", HttpStatus.NOT_FOUND)
        );
    }

    public List<Session> findAll() {
        return repository.findAll();
    }

    public Session create(SessionPostInputDTO session) {
        Session toBeSaved = SessionFactory.toEntity(session);
        return repository.save(toBeSaved);
    }

    public Session update(SessionPostInputDTO request, Long id) {
        Session session = repository.findById(id).orElseThrow(() -> new RestPanteraException("Sessão com id " + id + " não foi encontrada", HttpStatus.BAD_REQUEST));

        session.setMovieName(request.getMovieName());
        session.setStartingTime(request.getStartingTime());
        session.setEndingTime(request.getEndingTime());

        return repository.save(session);
    }

    public void delete(Long id) {
        Session session = repository.findById(id).orElseThrow(() -> new RestPanteraException("Sessão com id " + id + " não foi encontrada", HttpStatus.NOT_FOUND));
        repository.delete(session);
    }
}
