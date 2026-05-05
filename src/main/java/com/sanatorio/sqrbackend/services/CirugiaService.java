package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.Cirugia;
import com.sanatorio.sqrbackend.repositories.CirugiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CirugiaService {

    @Autowired
    private CirugiaRepository cirugiaRepository;

    public List<Cirugia> obtenerTodos() {
        return cirugiaRepository.findAll();
    }

    public Optional<Cirugia> obtenerPorId(Integer id) {
        return cirugiaRepository.findById(id);
    }

    public Cirugia crear(Cirugia entidad) {
        if (cirugiaRepository.existsByNombreCirugia(entidad.getNombreCirugia())) {
            throw new IllegalArgumentException("Ya existe una cirugía registrada con el nombre: " + entidad.getNombreCirugia());
        }
        return cirugiaRepository.save(entidad);
    }

    public Cirugia actualizar(Integer id, Cirugia entidadActualizada) {
        Cirugia entidadExistente = cirugiaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La cirugía con ID " + id + " no existe"));

        // Validar si el nombre cambió y si el nuevo ya existe
        if (!entidadExistente.getNombreCirugia().equalsIgnoreCase(entidadActualizada.getNombreCirugia()) &&
                cirugiaRepository.existsByNombreCirugia(entidadActualizada.getNombreCirugia())) {
            throw new IllegalArgumentException("Ya existe otra cirugía con el nombre: " + entidadActualizada.getNombreCirugia());
        }

        // Actualizamos los campos
        entidadExistente.setNombreCirugia(entidadActualizada.getNombreCirugia());
        entidadExistente.setRequiereCirculante(entidadActualizada.isRequiereCirculante());
        entidadExistente.setRequiereRx(entidadActualizada.isRequiereRx());
        entidadExistente.setRequiereMicroscopio(entidadActualizada.isRequiereMicroscopio());

        return cirugiaRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!cirugiaRepository.existsById(id)) {
            throw new IllegalArgumentException("La cirugía con ID " + id + " no existe");
        }
        cirugiaRepository.deleteById(id);
    }
}