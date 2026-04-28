package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

    boolean existsByNombreEquipo(String nombreEquipo);
}
