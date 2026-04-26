package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.Postoperatorio;
import com.sanatorio.sqrbackend.repositories.PostoperatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostoperatorioService {

    @Autowired
    private PostoperatorioRepository postoperatorioRepository;

    public List<Postoperatorio> obtenerTodos() {
        return postoperatorioRepository.findAll();
    }

    public Optional<Postoperatorio> obtenerPorId(Integer id) {
        return postoperatorioRepository.findById(id);
    }

    public Postoperatorio crear(Postoperatorio entidad) {
        if (postoperatorioRepository.existsByNombrePostoperatorio(entidad.getNombrePostoperatorio())) {
            throw new IllegalArgumentException("Ya existe un registro con el nombre: " + entidad.getNombrePostoperatorio());
        }
        return postoperatorioRepository.save(entidad);
    }

    public Postoperatorio actualizar(Integer id, Postoperatorio entidadActualizada) {
        Postoperatorio entidadExistente = postoperatorioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El registro con ID " + id + " no existe"));

        if (!entidadExistente.getNombrePostoperatorio().equals(entidadActualizada.getNombrePostoperatorio()) &&
                postoperatorioRepository.existsByNombrePostoperatorio(entidadActualizada.getNombrePostoperatorio())) {
            throw new IllegalArgumentException("Ya existe otro registro con el nombre: " + entidadActualizada.getNombrePostoperatorio());
        }

        entidadExistente.setNombrePostoperatorio(entidadActualizada.getNombrePostoperatorio());
        return postoperatorioRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!postoperatorioRepository.existsById(id)) {
            throw new IllegalArgumentException("El registro con ID " + id + " no existe");
        }
        postoperatorioRepository.deleteById(id);
    }
}


