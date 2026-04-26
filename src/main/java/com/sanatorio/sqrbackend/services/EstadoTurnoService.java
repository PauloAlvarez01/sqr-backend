package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.EstadoTurno;
import com.sanatorio.sqrbackend.repositories.EstadoTurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoTurnoService {

    @Autowired
    private EstadoTurnoRepository estadoTurnoRepository;

    public List<EstadoTurno> obtenerTodos() {
        return estadoTurnoRepository.findAll();
    }

    public Optional<EstadoTurno> obtenerPorId(Integer id) {
        return estadoTurnoRepository.findById(id);
    }

    public EstadoTurno crear(EstadoTurno entidad) {
        if (estadoTurnoRepository.existsByNombreEstadoTurno(entidad.getNombreEstadoTurno())) {
            throw new IllegalArgumentException("Ya existe un registro con el nombre: " + entidad.getNombreEstadoTurno());
        }
        return estadoTurnoRepository.save(entidad);
    }

    public EstadoTurno actualizar(Integer id, EstadoTurno entidadActualizada) {
        EstadoTurno entidadExistente = estadoTurnoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El registro con ID " + id + " no existe"));

        if (!entidadExistente.getNombreEstadoTurno().equals(entidadActualizada.getNombreEstadoTurno()) &&
                estadoTurnoRepository.existsByNombreEstadoTurno(entidadActualizada.getNombreEstadoTurno())) {
            throw new IllegalArgumentException("Ya existe otro registro con el nombre: " + entidadActualizada.getNombreEstadoTurno());
        }

        entidadExistente.setNombreEstadoTurno(entidadActualizada.getNombreEstadoTurno());
        return estadoTurnoRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!estadoTurnoRepository.existsById(id)) {
            throw new IllegalArgumentException("El registro con ID " + id + " no existe");
        }
        estadoTurnoRepository.deleteById(id);
    }
}

