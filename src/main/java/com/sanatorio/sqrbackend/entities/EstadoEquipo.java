package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estado_equipo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoEquipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoEquipo;

    @Column(nullable = false, length = 25, unique = true)
    private String nombreEstadoEquipo;
}

