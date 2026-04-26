package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.EstadoQuirofano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoQuirofanoRepository extends JpaRepository<EstadoQuirofano, Integer> {
}
