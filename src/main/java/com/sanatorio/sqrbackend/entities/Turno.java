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
import java.util.List;

@Entity
@Table(name = "turno")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTurno;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "matricula", nullable = false)
    private Cirujano cirujano;

    @ManyToOne
    @JoinColumn(name = "id_quirofano")
    private Quirofano quirofano;

    @Column(nullable = false)
    private LocalDate fechaCirugia;

    @Column(nullable = false)
    private LocalTime horaInicioEstimada;

    @Column(nullable = false)
    private LocalTime horaInicioProyectada;

    @Column(nullable = false)
    private Integer duracionEstimadaMinutos;

    @Column(nullable = false)
    private Integer duracionProyectada;

    @ManyToOne
    @JoinColumn(name = "id_tipo_anestesia", nullable = false)
    private TipoAnestesia tipoAnestesia;

    @ManyToOne
    @JoinColumn(name = "id_estado_turno", nullable = false)
    private EstadoTurno estadoTurno;

    @Column(nullable = false)
    private Boolean urgencia;

    @ManyToMany
    @JoinTable(
            name = "turno_equipo",
            joinColumns = @JoinColumn(name = "id_turno"),
            inverseJoinColumns = @JoinColumn(name = "id_equipo")
    )
    private List<Equipo> equiposRequeridos;

    @Column(nullable = false)
    private Boolean patologoPresente;

    @Column(nullable = false)
    private LocalDateTime fechaHoraSolicitud;

    @ManyToOne
    @JoinColumn(name = "id_cirugia", nullable = false)
    private Cirugia cirugia;

    @Column(length = 255)
    private String otraCirugia;

    @ManyToOne
    @JoinColumn(name = "id_postoperatorio", nullable = false)
    private Postoperatorio postoperatorio;

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

    @ManyToOne
    @JoinColumn(name = "id_obra_social", nullable = false)
    private ObraSocial obraSocial;
}



