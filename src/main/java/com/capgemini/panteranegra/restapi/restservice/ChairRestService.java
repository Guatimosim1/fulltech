package com.capgemini.panteranegra.restapi.restservice;

import com.capgemini.panteranegra.entities.Chair;
import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.exceptions.RestPanteraException;
import com.capgemini.panteranegra.models.CustomerNameInputDTO;
import com.capgemini.panteranegra.repositores.ChairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChairRestService {
    @Autowired
    private ChairRepository repository;

    public Chair findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestPanteraException("Cadeira com id "+id+" não foi encontrada", HttpStatus.NOT_FOUND));
    }

    public List<Chair> findAll() {
        return repository.findAll();
    }

    public Chair assignChairToCustomer(CustomerNameInputDTO customerName, Long id) {
        Chair chair = repository.findById(id).orElseThrow(() -> new RestPanteraException("Cadeira com id " + id + " não foi encontrada", HttpStatus.NOT_FOUND));
        if(chair.getStatus()) throw new RestPanteraException("Esta cadeira já foi assinalada ao cliente "+chair.getCostumerName(), HttpStatus.BAD_REQUEST);

        chair.setStatus(true);
        chair.setCostumerName(customerName.getNomeCliente());

        return repository.save(chair);
    }

    public List<Chair> findBySessionId(Long id) {
        return repository.findBySessionId(id);
    }
}
