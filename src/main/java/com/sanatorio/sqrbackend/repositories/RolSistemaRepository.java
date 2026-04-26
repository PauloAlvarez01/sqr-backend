package com.sanatorio.sqrbackend.repositories;

import com.sanatorio.sqrbackend.entities.RolSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolSistemaRepository extends JpaRepository<RolSistema, Integer> {

    // Verifico que no exista el nuevo registro, aunque la bbdd tiene AK en ese campo.
    boolean existsByNombreRolSistema(String nombreRolSistema);
}
