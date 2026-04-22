package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_anestesia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoAnestesia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoAnestesia;

    @Column(nullable = false, length = 25, unique = true)
    private String nombreTipoAnestesia;
}

