package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rol_sistema")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRolSistema;

    @Column(nullable = false, length = 25, unique = true)
    private String nombreRolSistema;
}
