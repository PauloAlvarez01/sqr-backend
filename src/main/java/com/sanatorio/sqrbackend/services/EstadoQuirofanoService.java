package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.EstadoQuirofano;
import com.sanatorio.sqrbackend.repositories.EstadoQuirofanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoQuirofanoService {

    @Autowired
    private EstadoQuirofanoRepository estadoQuirofanoRepository;

    public List<EstadoQuirofano> obtenerTodos() {
        return estadoQuirofanoRepository.findAll();
    }

    public Optional<EstadoQuirofano> obtenerPorId(Integer id) {
        return estadoQuirofanoRepository.findById(id);
    }

    public EstadoQuirofano crear(EstadoQuirofano entidad) {
        if (estadoQuirofanoRepository.existsByNombreEstadoQuirofano(entidad.getNombreEstadoQuirofano())) {
            throw new IllegalArgumentException("Ya existe un registro con el nombre: " + entidad.getNombreEstadoQuirofano());
        }
        return estadoQuirofanoRepository.save(entidad);
    }

    public EstadoQuirofano actualizar(Integer id, EstadoQuirofano entidadActualizada) {
        EstadoQuirofano entidadExistente = estadoQuirofanoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El registro con ID " + id + " no existe"));

        if (!entidadExistente.getNombreEstadoQuirofano().equals(entidadActualizada.getNombreEstadoQuirofano()) &&
                estadoQuirofanoRepository.existsByNombreEstadoQuirofano(entidadActualizada.getNombreEstadoQuirofano())) {
            throw new IllegalArgumentException("Ya existe otro registro con el nombre: " + entidadActualizada.getNombreEstadoQuirofano());
        }

        entidadExistente.setNombreEstadoQuirofano(entidadActualizada.getNombreEstadoQuirofano());
        return estadoQuirofanoRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!estadoQuirofanoRepository.existsById(id)) {
            throw new IllegalArgumentException("El registro con ID " + id + " no existe");
        }
        estadoQuirofanoRepository.deleteById(id);
    }
}

