package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(nullable = false, length = 25, unique = true)
    private String userName;

    @Column(nullable = false, length = 255)
    private String passwordHash;

    @Column(nullable = false)
    private Boolean activoUsuario;

    // --- RELACIONES OPCIONALES (N FK) ---
    // Puede no ser ni empleado ni cirujano

    @ManyToOne
    @JoinColumn(name = "matricula")
    private Cirujano cirujano;

    @ManyToOne
    @JoinColumn(name = "legajo")
    private Personal personal;

    @ManyToOne
    @JoinColumn(name = "id_rol_sistema", nullable = false)
    private RolSistema rolSistema;
}
