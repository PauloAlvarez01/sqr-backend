package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.Paciente;
import com.sanatorio.sqrbackend.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }
    public Paciente guardarPaciente(Paciente paciente) {
        // Acá más adelante agregaremos inteligencia (ej. validar que el DNI no exista)
        return pacienteRepository.save(paciente);
    }
}
