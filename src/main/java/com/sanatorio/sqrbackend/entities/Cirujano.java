package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cirujano")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cirujano {

    @Id
    private Integer matricula;

    @Column(nullable = false, length = 25)
    private String apellidoCirujano;

    @Column(nullable = false, length = 25)
    private String nombreCirujano;

    @Column(nullable = false, length = 25)
    private String emailCirujano;

    @Column(nullable = false, length = 25)
    private String telefonoCirujano;

    @Column(nullable = false)
    private Boolean activoCirujano;

    @ManyToOne // "Muchos cirujanos pueden tener una misma especialidad"
    @JoinColumn(name = "id_especialidad", nullable = false)
    private Especialidad especialidad;
}