package com.capgemini.panteranegra.repositores;

import com.capgemini.panteranegra.entities.Chair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChairRepository extends JpaRepository<Chair, Long> {
    Optional<Chair> findByCostomerName(String nomeCliente);
}
