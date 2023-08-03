package com.capgemini.panteranegra.repositores;

import com.capgemini.panteranegra.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
