package com.example.examfinalgtics.Entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "generos")
public class Generos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgenero" , nullable = false)
    private Integer idGenero;

    @Column(name = "nombre",length = 50)
    private String nombre;

    @Column(name = "descripcion",length = 200)
    private String descripcion;
}
