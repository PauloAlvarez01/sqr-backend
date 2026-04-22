package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estado_turno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoTurno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoTurno;

    @Column(nullable = false, length = 25, unique = true)
    private String nombreEstadoTurno;
}

