package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_evento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoEvento;

    @Column(nullable = false, length = 25, unique = true)
    private String nombreTipoEvento;
}
