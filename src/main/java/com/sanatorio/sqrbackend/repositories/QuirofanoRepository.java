package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.Quirofano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuirofanoRepository extends JpaRepository <Quirofano, Integer> {
}
