package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.Cirujano;
import com.sanatorio.sqrbackend.repositories.CirujanoRepository;
import com.sanatorio.sqrbackend.repositories.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CirujanoService {

    @Autowired
    private CirujanoRepository cirujanoRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Cirujano> obtenerTodos() {
        return cirujanoRepository.findAll();
    }

    public Optional<Cirujano> obtenerPorMatricula(Integer matricula) {
        return cirujanoRepository.findById(matricula);
    }

    public Cirujano crear(Cirujano entidad) {
        // 1. Validar que nos envíen la matrícula
        if (entidad.getMatricula() == null) {
            throw new IllegalArgumentException("La matrícula del cirujano es obligatoria");
        }

        // 2. Validar que la matrícula no esté ya registrada
        if (cirujanoRepository.existsById(entidad.getMatricula())) {
            throw new IllegalArgumentException("Ya existe un cirujano registrado con la matrícula: " + entidad.getMatricula());
        }

        // 3. Por defecto, asumimos que un cirujano nuevo ingresa activo
        if (entidad.getActivoCirujano() == null) {
            entidad.setActivoCirujano(true);
        }

        // 4. Validar que la especialidad asignada sea real
        validarEspecialidad(entidad);

        return cirujanoRepository.save(entidad);
    }

    public Cirujano actualizar(Integer matricula, Cirujano entidadActualizada) {
        Cirujano entidadExistente = cirujanoRepository.findById(matricula)
                .orElseThrow(() -> new IllegalArgumentException("El cirujano con matrícula " + matricula + " no existe"));

        // Validar que la nueva especialidad sea real
        validarEspecialidad(entidadActualizada);

        // Actualizamos los campos uno por uno
        entidadExistente.setApellidoCirujano(entidadActualizada.getApellidoCirujano());
        entidadExistente.setNombreCirujano(entidadActualizada.getNombreCirujano());
        entidadExistente.setEmailCirujano(entidadActualizada.getEmailCirujano());
        entidadExistente.setTelefonoCirujano(entidadActualizada.getTelefonoCirujano());
        entidadExistente.setActivoCirujano(entidadActualizada.getActivoCirujano());
        entidadExistente.setEspecialidad(entidadActualizada.getEspecialidad());

        return cirujanoRepository.save(entidadExistente);
    }

    // Suspender/reactivar un cirujano desde la grilla del frontend
    public Cirujano cambiarEstadoActivo(Integer matricula, boolean nuevoEstado) {
        Cirujano entidadExistente = cirujanoRepository.findById(matricula)
                .orElseThrow(() -> new IllegalArgumentException("El cirujano con matrícula " + matricula + " no existe"));

        entidadExistente.setActivoCirujano(nuevoEstado);
        return cirujanoRepository.save(entidadExistente);
    }

    public void eliminar(Integer matricula) {
        if (!cirujanoRepository.existsById(matricula)) {
            throw new IllegalArgumentException("El cirujano con matrícula " + matricula + " no existe");
        }
        cirujanoRepository.deleteById(matricula);
    }

    private void validarEspecialidad(Cirujano entidad) {
        if (entidad.getEspecialidad() == null || entidad.getEspecialidad().getIdEspecialidad() == null) {
            throw new IllegalArgumentException("El cirujano debe tener una Especialidad asignada obligatoriamente");
        }

        if (!especialidadRepository.existsById(entidad.getEspecialidad().getIdEspecialidad())) {
            throw new IllegalArgumentException("La Especialidad indicada no existe en el sistema");
        }
    }
}
