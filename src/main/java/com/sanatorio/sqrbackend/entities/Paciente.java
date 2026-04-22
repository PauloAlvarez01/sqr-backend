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

@Entity
@Table(name = "paciente")
@EntityListeners(AuditingEntityListener.class) // para autocompletar los campos de auditoria
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;

    @Column(nullable = false, length = 25)
    private String apellidoPaciente;

    @Column(nullable = false, length = 25)
    private String nombrePaciente;

    @Column(length = 25)
    private String sexoPaciente;

    @Column(nullable = false, length = 15, unique = true)
    private String dni;

    @Column(nullable = false, length = 25)
    private String telefonoPaciente;

    @Column(length = 100)
    private String emailPaciente;

    @Column(nullable = false)
    private LocalDate fechaNacimientoPaciente;

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
