package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "evento_turno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventoTurno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEventoTurno;

    @ManyToOne
    @JoinColumn(name = "id_turno", nullable = false)
    private Turno turno;

    @ManyToOne
    @JoinColumn(name = "id_tipo_evento", nullable = false)
    private TipoEvento tipoEvento;

    @ManyToOne
    @JoinColumn(name = "legajo", nullable = false)
    private Personal personal;

    @Column(nullable = false)
    private LocalDateTime timestampEventoTurno;
}
