package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.Quirofano;
import com.sanatorio.sqrbackend.repositories.EstadoQuirofanoRepository;
import com.sanatorio.sqrbackend.repositories.QuirofanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuirofanoService {

    @Autowired
    private QuirofanoRepository quirofanoRepository;

    @Autowired
    private EstadoQuirofanoRepository estadoQuirofanoRepository;

    public List<Quirofano> obtenerTodos() {
        return quirofanoRepository.findAll();
    }

    public Optional<Quirofano> obtenerPorId(Integer id) {
        return quirofanoRepository.findById(id);
    }

    public Quirofano crear(Quirofano entidad) {
        // 1. Validamos que el ID (número de sala) no esté ocupado
        if (entidad.getIdQuirofano() != null && quirofanoRepository.existsById(entidad.getIdQuirofano())) {
            throw new IllegalArgumentException("Ya existe un Quirófano con el número: " + entidad.getIdQuirofano());
        }

        // 2. Validamos que el nombre no esté ocupado
        if (quirofanoRepository.existsByNombreQuirofano(entidad.getNombreQuirofano())) {
            throw new IllegalArgumentException("Ya existe un Quirófano con el nombre: " + entidad.getNombreQuirofano());
        }

        // 3. Validar que nos manden un Estado y que ese Estado exista en la BBDD
        validarEstadoQuirofano(entidad);

        return quirofanoRepository.save(entidad);
    }

    public Quirofano actualizar(Integer id, Quirofano entidadActualizada) {
        Quirofano entidadExistente = quirofanoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El Quirófano con número " + id + " no existe"));

        // Validar si le cambiaron el nombre y que el nuevo no esté ocupado
        if (!entidadExistente.getNombreQuirofano().equals(entidadActualizada.getNombreQuirofano()) &&
                quirofanoRepository.existsByNombreQuirofano(entidadActualizada.getNombreQuirofano())) {
            throw new IllegalArgumentException("Ya existe otro Quirófano con el nombre: " + entidadActualizada.getNombreQuirofano());
        }

        // Validar que el nuevo estado sea válido
        validarEstadoQuirofano(entidadActualizada);

        // Actualizamos los datos
        entidadExistente.setNombreQuirofano(entidadActualizada.getNombreQuirofano());
        entidadExistente.setTipoQuirofano(entidadActualizada.getTipoQuirofano());
        entidadExistente.setEstadoQuirofano(entidadActualizada.getEstadoQuirofano());

        return quirofanoRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!quirofanoRepository.existsById(id)) {
            throw new IllegalArgumentException("El Quirófano con número " + id + " no existe");
        }
        quirofanoRepository.deleteById(id);
    }

    private void validarEstadoQuirofano(Quirofano entidad) {
        if (entidad.getEstadoQuirofano() == null || entidad.getEstadoQuirofano().getIdEstadoQuirofano() == null) {
            throw new IllegalArgumentException("El Quirófano debe tener un Estado asignado obligatoriamente");
        }

        if (!estadoQuirofanoRepository.existsById(entidad.getEstadoQuirofano().getIdEstadoQuirofano())) {
            throw new IllegalArgumentException("El Estado de Quirófano indicado no existe en el sistema");
        }
    }
}
