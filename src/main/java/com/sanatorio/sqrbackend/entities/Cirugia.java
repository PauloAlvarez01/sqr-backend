package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cirugia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cirugia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCirugia;

    @Column(nullable = false, length = 25, unique = true)
    private String nombreCirugia;
}

