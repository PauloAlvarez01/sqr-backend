package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.EstadoEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoEquipoRepository extends JpaRepository<EstadoEquipo, Integer> {
}
