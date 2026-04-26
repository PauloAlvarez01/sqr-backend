package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.TipoAnestesia;
import com.sanatorio.sqrbackend.repositories.TipoAnestesiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoAnestesiaService {

    @Autowired
    private TipoAnestesiaRepository tipoAnestesiaRepository;

    public List<TipoAnestesia> obtenerTodos() {
        return tipoAnestesiaRepository.findAll();
    }

    public Optional<TipoAnestesia> obtenerPorId(Integer id) {
        return tipoAnestesiaRepository.findById(id);
    }

    public TipoAnestesia crear(TipoAnestesia entidad) {
        if (tipoAnestesiaRepository.existsByNombreTipoAnestesia(entidad.getNombreTipoAnestesia())) {
            throw new IllegalArgumentException("Ya existe un registro con el nombre: " + entidad.getNombreTipoAnestesia());
        }
        return tipoAnestesiaRepository.save(entidad);
    }

    public TipoAnestesia actualizar(Integer id, TipoAnestesia entidadActualizada) {
        TipoAnestesia entidadExistente = tipoAnestesiaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El registro con ID " + id + " no existe"));

        if (!entidadExistente.getNombreTipoAnestesia().equals(entidadActualizada.getNombreTipoAnestesia()) &&
                tipoAnestesiaRepository.existsByNombreTipoAnestesia(entidadActualizada.getNombreTipoAnestesia())) {
            throw new IllegalArgumentException("Ya existe otro registro con el nombre: " + entidadActualizada.getNombreTipoAnestesia());
        }

        entidadExistente.setNombreTipoAnestesia(entidadActualizada.getNombreTipoAnestesia());
        return tipoAnestesiaRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!tipoAnestesiaRepository.existsById(id)) {
            throw new IllegalArgumentException("El registro con ID " + id + " no existe");
        }
        tipoAnestesiaRepository.deleteById(id);
    }
}

