package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Integer> {
}
