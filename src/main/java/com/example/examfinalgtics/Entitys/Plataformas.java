package com.example.examfinalgtics.Entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "plataformas")
public class Plataformas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplataforma" , nullable = false)
    private Integer idPlataforma;

    @Column(name = "nombre",length = 50)
    private String nombre;

    @Column(name = "descripcion",length = 200)
    private String descripcion;
}
