package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.EstadoPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPersonalRepository extends JpaRepository<EstadoPersonal, Integer> {
}
