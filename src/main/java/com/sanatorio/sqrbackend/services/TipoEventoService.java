package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.TipoEvento;
import com.sanatorio.sqrbackend.repositories.TipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEventoService {

    @Autowired
    private TipoEventoRepository tipoEventoRepository;

    public List<TipoEvento> obtenerTodos() {
        return tipoEventoRepository.findAll();
    }

    public Optional<TipoEvento> obtenerPorId(Integer id) {
        return tipoEventoRepository.findById(id);
    }

    public TipoEvento crear(TipoEvento entidad) {
        if (tipoEventoRepository.existsByNombreTipoEvento(entidad.getNombreTipoEvento())) {
            throw new IllegalArgumentException("Ya existe un registro con el nombre: " + entidad.getNombreTipoEvento());
        }
        return tipoEventoRepository.save(entidad);
    }

    public TipoEvento actualizar(Integer id, TipoEvento entidadActualizada) {
        TipoEvento entidadExistente = tipoEventoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El registro con ID " + id + " no existe"));

        if (!entidadExistente.getNombreTipoEvento().equals(entidadActualizada.getNombreTipoEvento()) &&
                tipoEventoRepository.existsByNombreTipoEvento(entidadActualizada.getNombreTipoEvento())) {
            throw new IllegalArgumentException("Ya existe otro registro con el nombre: " + entidadActualizada.getNombreTipoEvento());
        }

        entidadExistente.setNombreTipoEvento(entidadActualizada.getNombreTipoEvento());
        return tipoEventoRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!tipoEventoRepository.existsById(id)) {
            throw new IllegalArgumentException("El registro con ID " + id + " no existe");
        }
        tipoEventoRepository.deleteById(id);
    }
}


