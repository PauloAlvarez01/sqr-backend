package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.EstadoEquipo;
import com.sanatorio.sqrbackend.repositories.EstadoEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoEquipoService {

    @Autowired
    private EstadoEquipoRepository estadoEquipoRepository;

    public List<EstadoEquipo> obtenerTodos() {
        return estadoEquipoRepository.findAll();
    }

    public Optional<EstadoEquipo> obtenerPorId(Integer id) {
        return estadoEquipoRepository.findById(id);
    }

    public EstadoEquipo crear(EstadoEquipo entidad) {
        if (estadoEquipoRepository.existsByNombreEstadoEquipo(entidad.getNombreEstadoEquipo())) {
            throw new IllegalArgumentException("Ya existe un registro con el nombre: " + entidad.getNombreEstadoEquipo());
        }
        return estadoEquipoRepository.save(entidad);
    }

    public EstadoEquipo actualizar(Integer id, EstadoEquipo entidadActualizada) {
        EstadoEquipo entidadExistente = estadoEquipoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El registro con ID " + id + " no existe"));

        if (!entidadExistente.getNombreEstadoEquipo().equals(entidadActualizada.getNombreEstadoEquipo()) &&
                estadoEquipoRepository.existsByNombreEstadoEquipo(entidadActualizada.getNombreEstadoEquipo())) {
            throw new IllegalArgumentException("Ya existe otro registro con el nombre: " + entidadActualizada.getNombreEstadoEquipo());
        }

        entidadExistente.setNombreEstadoEquipo(entidadActualizada.getNombreEstadoEquipo());
        return estadoEquipoRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!estadoEquipoRepository.existsById(id)) {
            throw new IllegalArgumentException("El registro con ID " + id + " no existe");
        }
        estadoEquipoRepository.deleteById(id);
    }
}

