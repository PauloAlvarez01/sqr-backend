package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "paciente")
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

    @Column(nullable = false, length = 25)
    private String creadoPor;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false, length = 25)
    private String modificadoPor;

    @Column(nullable = false)
    private LocalDateTime fechaModificacion;

    @ManyToOne
    @JoinColumn(name = "id_obra_social", nullable = false)
    private ObraSocial obraSocial;
}
