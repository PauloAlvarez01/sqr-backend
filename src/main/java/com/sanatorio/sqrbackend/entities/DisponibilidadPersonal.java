package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "disponibilidad_personal")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisponibilidadPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDisponibilidadPersonal;

    @Column(nullable = false)
    private LocalDate fechaDisponibilidadPersonal;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "legajo", nullable = false)
    private Personal personal;

    @ManyToOne
    @JoinColumn(name = "id_estado_personal", nullable = false)
    private EstadoPersonal estadoPersonal;

    @CreatedBy
    @Column(nullable = false, updatable = false, length = 25)
    private String creadoPor;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedBy
    @Column(nullable = false, length = 25)
    private String modificadoPor;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime fechaModificacion;
}
