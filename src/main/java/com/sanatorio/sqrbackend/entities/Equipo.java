package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "equipo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipo;

    @Column(nullable = false, length = 25, unique = true)
    private String nombreEquipo;

    @Column(nullable = false)
    private Boolean esMovil;

    @ManyToOne
    @JoinColumn(name = "id_estado_equipo", nullable = false)
    private EstadoEquipo estadoEquipo;

    @ManyToOne
    @JoinColumn(name = "id_quirofano")
    private Quirofano quirofano;
}


