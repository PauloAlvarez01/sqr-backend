package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEventoRepository extends JpaRepository<TipoEvento, Integer> {

    boolean existsByNombreTipoEvento(String nombreTipoEvento);
}
