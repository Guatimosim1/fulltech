package com.capgemini.panteranegra.repositores;

import com.capgemini.panteranegra.entities.Chair;
import com.capgemini.panteranegra.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChairRepository extends JpaRepository<Chair, Long> {
    Optional<Chair> findByCostumerName(String nomeCliente);
    List<Chair> findBySession(Session session);
}
