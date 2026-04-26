package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.EventoTurno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoTurnoRepository extends JpaRepository<EventoTurno, Integer> {
}
