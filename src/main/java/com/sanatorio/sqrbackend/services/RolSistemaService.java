package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.RolSistema;
import com.sanatorio.sqrbackend.repositories.RolSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolSistemaService {

    @Autowired
    private RolSistemaRepository rolSistemaRepository;

    public List<RolSistema> obtenerTodos() {
        return rolSistemaRepository.findAll();
    }

    public Optional<RolSistema> obtenerPorId(Integer id) {
        return rolSistemaRepository.findById(id);
    }

    public RolSistema crear(RolSistema entidad) {
        if (rolSistemaRepository.existsByNombreRolSistema(entidad.getNombreRolSistema())) {
            throw new IllegalArgumentException("Ya existe un registro con el nombre: " + entidad.getNombreRolSistema());
        }
        return rolSistemaRepository.save(entidad);
    }

    public RolSistema actualizar(Integer id, RolSistema entidadActualizada) {
        RolSistema entidadExistente = rolSistemaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El registro con ID " + id + " no existe"));

        if (!entidadExistente.getNombreRolSistema().equals(entidadActualizada.getNombreRolSistema()) &&
                rolSistemaRepository.existsByNombreRolSistema(entidadActualizada.getNombreRolSistema())) {
            throw new IllegalArgumentException("Ya existe otro registro con el nombre: " + entidadActualizada.getNombreRolSistema());
        }

        entidadExistente.setNombreRolSistema(entidadActualizada.getNombreRolSistema());
        return rolSistemaRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!rolSistemaRepository.existsById(id)) {
            throw new IllegalArgumentException("El registro con ID " + id + " no existe");
        }
        rolSistemaRepository.deleteById(id);
    }
}