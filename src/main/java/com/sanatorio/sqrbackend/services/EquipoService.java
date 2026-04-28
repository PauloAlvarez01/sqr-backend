package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.Equipo;
import com.sanatorio.sqrbackend.repositories.EquipoRepository;
import com.sanatorio.sqrbackend.repositories.EstadoEquipoRepository;
import com.sanatorio.sqrbackend.repositories.QuirofanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private EstadoEquipoRepository estadoEquipoRepository;

    @Autowired
    private QuirofanoRepository quirofanoRepository;

    public List<Equipo> obtenerTodos() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> obtenerPorId(Integer id) {
        return equipoRepository.findById(id);
    }

    public Equipo crear(Equipo entidad) {
        // 1. Validamos que el nombre (o número de serie) no esté repetido
        if (equipoRepository.existsByNombreEquipo(entidad.getNombreEquipo())) {
            throw new IllegalArgumentException("Ya existe un Equipo con el nombre: " + entidad.getNombreEquipo());
        }

        // Si no nos mandan el dato de si es móvil
        if (entidad.getEsMovil() == null) {
            entidad.setEsMovil(true);
        }

        // 2. Validaciones de relaciones (Claves Foráneas)
        validarEstadoEquipo(entidad);
        validarQuirofano(entidad);

        return equipoRepository.save(entidad);
    }

    public Equipo actualizar(Integer id, Equipo entidadActualizada) {
        Equipo entidadExistente = equipoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El Equipo con ID " + id + " no existe"));

        // Validamos si le cambiaron el nombre y que el nuevo no esté ocupado
        if (!entidadExistente.getNombreEquipo().equals(entidadActualizada.getNombreEquipo()) &&
                equipoRepository.existsByNombreEquipo(entidadActualizada.getNombreEquipo())) {
            throw new IllegalArgumentException("Ya existe otro Equipo con el nombre: " + entidadActualizada.getNombreEquipo());
        }

        // Validamos las relaciones
        validarEstadoEquipo(entidadActualizada);
        validarQuirofano(entidadActualizada);

        // Actualizamos los datos campo por campo para no pisar con nulls
        entidadExistente.setNombreEquipo(entidadActualizada.getNombreEquipo());
        entidadExistente.setEsMovil(entidadActualizada.getEsMovil());
        entidadExistente.setEstadoEquipo(entidadActualizada.getEstadoEquipo());
        entidadExistente.setQuirofano(entidadActualizada.getQuirofano());

        return equipoRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!equipoRepository.existsById(id)) {
            throw new IllegalArgumentException("El Equipo con ID " + id + " no existe");
        }
        equipoRepository.deleteById(id);
    }

    // VALIDACIÓN OBLIGATORIA: Un equipo no puede existir sin estado
    private void validarEstadoEquipo(Equipo entidad) {
        if (entidad.getEstadoEquipo() == null || entidad.getEstadoEquipo().getIdEstadoEquipo() == null) {
            throw new IllegalArgumentException("El Equipo debe tener un Estado asignado obligatoriamente");
        }

        if (!estadoEquipoRepository.existsById(entidad.getEstadoEquipo().getIdEstadoEquipo())) {
            throw new IllegalArgumentException("El Estado de Equipo indicado no existe en el sistema");
        }
    }

    // VALIDACIÓN OPCIONAL: Un equipo puede no tener Quirófano, pero si lo mandan, debe existir
    private void validarQuirofano(Equipo entidad) {
        // Si no mandan quirófano, salimos
        if (entidad.getQuirofano() == null || entidad.getQuirofano().getIdQuirofano() == null) {
            return;
        }

        // Pero si mandaron un ID de quirófano, validamos que sea real
        if (!quirofanoRepository.existsById(entidad.getQuirofano().getIdQuirofano())) {
            throw new IllegalArgumentException("El Quirófano asignado al equipo no existe en el sistema");
        }
    }
}
