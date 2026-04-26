package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.Rol;
import com.sanatorio.sqrbackend.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerPorId(Integer id) {
        return rolRepository.findById(id);
    }

    public Rol crear(Rol entidad) {
        if (rolRepository.existsByNombreRol(entidad.getNombreRol())) {
            throw new IllegalArgumentException("Ya existe un registro con el nombre: " + entidad.getNombreRol());
        }
        return rolRepository.save(entidad);
    }

    public Rol actualizar(Integer id, Rol entidadActualizada) {
        Rol entidadExistente = rolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El registro con ID " + id + " no existe"));

        if (!entidadExistente.getNombreRol().equals(entidadActualizada.getNombreRol()) &&
                rolRepository.existsByNombreRol(entidadActualizada.getNombreRol())) {
            throw new IllegalArgumentException("Ya existe otro registro con el nombre: " + entidadActualizada.getNombreRol());
        }

        entidadExistente.setNombreRol(entidadActualizada.getNombreRol());
        return rolRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!rolRepository.existsById(id)) {
            throw new IllegalArgumentException("El registro con ID " + id + " no existe");
        }
        rolRepository.deleteById(id);
    }
}