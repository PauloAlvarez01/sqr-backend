package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository <Turno, Integer> {
}
