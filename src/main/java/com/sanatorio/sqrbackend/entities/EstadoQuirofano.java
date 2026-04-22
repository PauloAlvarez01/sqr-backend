package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estado_quirofano")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoQuirofano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoQuirofano;

    @Column(nullable = false, length = 25, unique = true)
    private String nombreEstadoQuirofano;
}

