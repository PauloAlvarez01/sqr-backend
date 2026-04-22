package com.sanatorio.sqrbackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "postoperatorio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Postoperatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPostoperatorio;

    @Column(nullable = false, length = 5, unique = true)
    private String nombrePostoperatorio;
}

