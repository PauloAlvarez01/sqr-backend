package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {


    boolean existsByNombreEspecialidad(String nombreEspecialidad);
}
