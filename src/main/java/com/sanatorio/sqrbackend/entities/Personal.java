package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "personal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personal {

    @Id
    private Integer legajo;

    @Column(nullable = false, length = 25)
    private String apellidoPersonal;

    @Column(nullable = false, length = 25)
    private String nombrePersonal;

    @Column(nullable = false)
    private Boolean activoPersonal;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;
}
