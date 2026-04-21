package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "obra_social")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObraSocial {

    @Id
    private Integer idObraSocial;

    @Column(nullable = false, length = 25, unique = true)
    private String nombreObraSocial;

    @Column(nullable = false)
    private Boolean activaObraSocial;
}
