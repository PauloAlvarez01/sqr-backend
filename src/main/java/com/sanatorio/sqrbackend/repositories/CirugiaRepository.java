package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.Cirugia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CirugiaRepository extends JpaRepository<Cirugia, Integer> {
}
