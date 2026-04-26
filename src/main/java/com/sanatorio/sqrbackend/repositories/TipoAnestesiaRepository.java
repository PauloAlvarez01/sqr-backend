package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.TipoAnestesia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAnestesiaRepository extends JpaRepository<TipoAnestesia, Integer> {

    boolean existsByNombreTipoAnestesia(String nombreTipoAnestesia);
}
