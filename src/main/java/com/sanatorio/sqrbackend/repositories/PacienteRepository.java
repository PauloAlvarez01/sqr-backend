package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    boolean existsByDni(String dni);

    Optional<Paciente> findByDni(String dni);

    List<Paciente> findByApellidoPacienteContainingIgnoreCase(String apellido);

    List<Paciente> findByApellidoPacienteContainingIgnoreCaseAndNombrePacienteContainingIgnoreCase(String apellido, String nombre);
}
