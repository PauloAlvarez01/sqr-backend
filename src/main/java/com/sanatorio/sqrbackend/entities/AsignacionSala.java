package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "asignacion_sala")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsignacionSala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignacion;

    @ManyToOne
    @JoinColumn(name = "id_disponibilidad_personal", nullable = false)
    private DisponibilidadPersonal disponibilidadPersonal;

    @ManyToOne
    @JoinColumn(name = "id_quirofano", nullable = false)
    private Quirofano quirofano;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol; // Este representa la función operativa en la sala (ej. Circulante)
}
