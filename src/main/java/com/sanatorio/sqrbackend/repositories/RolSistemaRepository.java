package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.RolSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolSistemaRepository extends JpaRepository<RolSistema, Integer> {
}
