package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.AsignacionSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionSalaRepository extends JpaRepository<AsignacionSala, Integer> {

    // Para saber quiénes están asignados a un quirófano específico
    List<AsignacionSala> findByQuirofano_IdQuirofano(Integer idQuirofano);

    // Para verificar si una disponibilidad de personal ya tiene una sala asignada
    boolean existsByDisponibilidadPersonal_IdDisponibilidadPersonal(Integer idDisponibilidadPersonal);

    // Para obtener la asignación de una disponibilidad específica
    List<AsignacionSala> findByDisponibilidadPersonal_IdDisponibilidadPersonal(Integer idDisponibilidadPersonal);
}
