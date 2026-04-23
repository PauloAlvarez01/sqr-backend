package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quirofano")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quirofano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idQuirofano;

    @Column(nullable = false, length = 25, unique = true)
    private String nombreQuirofano;

    @Column(nullable = false, length = 25)
    private String tipoQuirofano;

    @ManyToOne
    @JoinColumn(name = "id_estado_quirofano", nullable = false)
    private EstadoQuirofano estadoQuirofano;
}

