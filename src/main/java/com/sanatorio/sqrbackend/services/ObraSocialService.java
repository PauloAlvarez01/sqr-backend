package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.ObraSocial;
import com.sanatorio.sqrbackend.repositories.ObraSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraSocialService {

    @Autowired
    private ObraSocialRepository obraSocialRepository;

    public List<ObraSocial> obtenerTodos() {
        return obraSocialRepository.findAll();
    }

    public Optional<ObraSocial> obtenerPorId(Integer id) {
        return obraSocialRepository.findById(id);
    }

    public ObraSocial crear(ObraSocial entidad) {
        // 1. Validamos que el ID (código manual) no esté repetido
        if (entidad.getIdObraSocial() != null && obraSocialRepository.existsById(entidad.getIdObraSocial())) {
            throw new IllegalArgumentException("Ya existe una Obra Social con el código: " + entidad.getIdObraSocial());
        }

        // 2. Validamos que el nombre no esté repetido
        if (obraSocialRepository.existsByNombreObraSocial(entidad.getNombreObraSocial())) {
            throw new IllegalArgumentException("Ya existe una Obra Social con el nombre: " + entidad.getNombreObraSocial());
        }

        // Por defecto, al crear una obra social, asumimos que está activa
        if (entidad.getActivaObraSocial() == null) {
            entidad.setActivaObraSocial(true);
        }

        return obraSocialRepository.save(entidad);
    }

    public ObraSocial actualizar(Integer id, ObraSocial entidadActualizada) {
        ObraSocial entidadExistente = obraSocialRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La Obra Social con código " + id + " no existe"));

        if (!entidadExistente.getNombreObraSocial().equals(entidadActualizada.getNombreObraSocial()) &&
                obraSocialRepository.existsByNombreObraSocial(entidadActualizada.getNombreObraSocial())) {
            throw new IllegalArgumentException("Ya existe otra Obra Social con el nombre: " + entidadActualizada.getNombreObraSocial());
        }

        entidadExistente.setNombreObraSocial(entidadActualizada.getNombreObraSocial());
        // También permitimos actualizar el estado desde la edición completa
        entidadExistente.setActivaObraSocial(entidadActualizada.getActivaObraSocial());

        return obraSocialRepository.save(entidadExistente);
    }

    // Para el botón rápido de "Activar/Desactivar" en el frontend
    public ObraSocial cambiarEstadoActivo(Integer id, boolean nuevoEstado) {
        ObraSocial entidadExistente = obraSocialRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La Obra Social con código " + id + " no existe"));

        entidadExistente.setActivaObraSocial(nuevoEstado);
        return obraSocialRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!obraSocialRepository.existsById(id)) {
            throw new IllegalArgumentException("La Obra Social con código " + id + " no existe");
        }
        obraSocialRepository.deleteById(id);
    }
}
