package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.Especialidad;
import com.sanatorio.sqrbackend.repositories.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> obtenerTodos() {
        return especialidadRepository.findAll();
    }

    public Optional<Especialidad> obtenerPorId(Integer id) {
        return especialidadRepository.findById(id);
    }

    public Especialidad crear(Especialidad entidad) {
        if (especialidadRepository.existsByNombreEspecialidad(entidad.getNombreEspecialidad())) {
            throw new IllegalArgumentException("Ya existe un registro con el nombre: " + entidad.getNombreEspecialidad());
        }
        return especialidadRepository.save(entidad);
    }

    public Especialidad actualizar(Integer id, Especialidad entidadActualizada) {
        Especialidad entidadExistente = especialidadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El registro con ID " + id + " no existe"));

        if (!entidadExistente.getNombreEspecialidad().equals(entidadActualizada.getNombreEspecialidad()) &&
                especialidadRepository.existsByNombreEspecialidad(entidadActualizada.getNombreEspecialidad())) {
            throw new IllegalArgumentException("Ya existe otro registro con el nombre: " + entidadActualizada.getNombreEspecialidad());
        }

        entidadExistente.setNombreEspecialidad(entidadActualizada.getNombreEspecialidad());
        return especialidadRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!especialidadRepository.existsById(id)) {
            throw new IllegalArgumentException("El registro con ID " + id + " no existe");
        }
        especialidadRepository.deleteById(id);
    }
}
