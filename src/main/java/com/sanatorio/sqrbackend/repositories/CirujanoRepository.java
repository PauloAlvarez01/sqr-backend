package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.Cirujano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CirujanoRepository extends JpaRepository <Cirujano, String> {
}
