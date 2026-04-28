package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.ObraSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraSocialRepository extends JpaRepository<ObraSocial, Integer> {

    boolean existsByNombreObraSocial(String nombreObraSocial);
}
