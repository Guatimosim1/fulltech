package com.capgemini.panteranegra.repositores;

import com.capgemini.panteranegra.entities.Chair;
import com.capgemini.panteranegra.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChairRepository extends JpaRepository<Chair, Long> {
    Optional<Chair> findByCostumerName(String nomeCliente);
    List<Chair> findBySession(Session session);

    @Query(value = "SELECT * FROM cadeiras WHERE id_sessao = :id", nativeQuery = true)
    List<Chair> findBySessionId(@Param("id") Long id);
}
