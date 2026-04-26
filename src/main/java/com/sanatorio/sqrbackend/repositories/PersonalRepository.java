package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {
}
