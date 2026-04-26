package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.DisponibilidadPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadPersonalRepository extends JpaRepository<DisponibilidadPersonal, Integer> {
}
