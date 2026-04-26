package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.Postoperatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostoperatorioRepository extends JpaRepository<Postoperatorio, Integer> {

    boolean existsByNombrePostoperatorio(String nombrePostoperatorio);
}
