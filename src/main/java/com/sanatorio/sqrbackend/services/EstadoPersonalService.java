package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.EstadoPersonal;
import com.sanatorio.sqrbackend.repositories.EstadoPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoPersonalService {

    @Autowired
    private EstadoPersonalRepository estadoPersonalRepository;

    public List<EstadoPersonal> obtenerTodos() {
        return estadoPersonalRepository.findAll();
    }

    public Optional<EstadoPersonal> obtenerPorId(Integer id) {
        return estadoPersonalRepository.findById(id);
    }

    public EstadoPersonal crear(EstadoPersonal entidad) {
        if (estadoPersonalRepository.existsByNombreEstadoPersonal(entidad.getNombreEstadoPersonal())) {
            throw new IllegalArgumentException("Ya existe un registro con el nombre: " + entidad.getNombreEstadoPersonal());
        }
        return estadoPersonalRepository.save(entidad);
    }

    public EstadoPersonal actualizar(Integer id, EstadoPersonal entidadActualizada) {
        EstadoPersonal entidadExistente = estadoPersonalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El registro con ID " + id + " no existe"));

        if (!entidadExistente.getNombreEstadoPersonal().equals(entidadActualizada.getNombreEstadoPersonal()) &&
                estadoPersonalRepository.existsByNombreEstadoPersonal(entidadActualizada.getNombreEstadoPersonal())) {
            throw new IllegalArgumentException("Ya existe otro registro con el nombre: " + entidadActualizada.getNombreEstadoPersonal());
        }

        entidadExistente.setNombreEstadoPersonal(entidadActualizada.getNombreEstadoPersonal());
        return estadoPersonalRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!estadoPersonalRepository.existsById(id)) {
            throw new IllegalArgumentException("El registro con ID " + id + " no existe");
        }
        estadoPersonalRepository.deleteById(id);
    }
}
