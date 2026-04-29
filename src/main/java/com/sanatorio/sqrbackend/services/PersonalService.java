package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.Personal;
import com.sanatorio.sqrbackend.repositories.PersonalRepository;
import com.sanatorio.sqrbackend.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private RolRepository rolRepository;

    public List<Personal> obtenerTodos() {
        return personalRepository.findAll();
    }

    public Optional<Personal> obtenerPorLegajo(Integer legajo) {
        return personalRepository.findById(legajo);
    }

    public Personal crear(Personal entidad) {
        // 1. Validar que el legajo no venga vacío
        if (entidad.getLegajo() == null) {
            throw new IllegalArgumentException("El legajo del personal es obligatorio");
        }

        // 2. Validar que el legajo no esté duplicado
        if (personalRepository.existsById(entidad.getLegajo())) {
            throw new IllegalArgumentException("Ya existe un miembro del personal registrado con el legajo: " + entidad.getLegajo());
        }

        // 3. Por defecto, si no mandan el estado, el empleado ingresa activo
        if (entidad.getActivoPersonal() == null) {
            entidad.setActivoPersonal(true);
        }

        // 4. Validar que el Rol asignado sea real
        validarRol(entidad);

        return personalRepository.save(entidad);
    }

    public Personal actualizar(Integer legajo, Personal entidadActualizada) {
        Personal entidadExistente = personalRepository.findById(legajo)
                .orElseThrow(() -> new IllegalArgumentException("El personal con legajo " + legajo + " no existe"));

        // Validar que el nuevo rol sea real
        validarRol(entidadActualizada);

        // Actualizamos los campos uno por uno
        entidadExistente.setApellidoPersonal(entidadActualizada.getApellidoPersonal());
        entidadExistente.setNombrePersonal(entidadActualizada.getNombrePersonal());
        entidadExistente.setActivoPersonal(entidadActualizada.getActivoPersonal());
        entidadExistente.setRol(entidadActualizada.getRol());

        return personalRepository.save(entidadExistente);
    }

    // Suspender/reactivar personal desde la grilla del frontend
    public Personal cambiarEstadoActivo(Integer legajo, boolean nuevoEstado) {
        Personal entidadExistente = personalRepository.findById(legajo)
                .orElseThrow(() -> new IllegalArgumentException("El personal con legajo " + legajo + " no existe"));

        entidadExistente.setActivoPersonal(nuevoEstado);
        return personalRepository.save(entidadExistente);
    }

    public void eliminar(Integer legajo) {
        if (!personalRepository.existsById(legajo)) {
            throw new IllegalArgumentException("El personal con legajo " + legajo + " no existe");
        }
        personalRepository.deleteById(legajo);
    }

    private void validarRol(Personal entidad) {
        if (entidad.getRol() == null || entidad.getRol().getIdRol() == null) {
            throw new IllegalArgumentException("El personal debe tener un Rol asignado obligatoriamente");
        }

        if (!rolRepository.existsById(entidad.getRol().getIdRol())) {
            throw new IllegalArgumentException("El Rol indicado no existe en el sistema");
        }
    }
}
