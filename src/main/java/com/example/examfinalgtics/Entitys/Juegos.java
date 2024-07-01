package com.example.examfinalgtics.Entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "juegos")
public class Juegos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjuego" , nullable = false)
    private Integer idJuego;

    @Column(name = "nombre",length = 50)
    private String nombre;

    @Column(name = "descripcion",length = 448)
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "image",length = 400)
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "idgenero")
    private Generos genero;

    @ManyToOne
    @JoinColumn(name = "idplataforma")
    private Plataformas plataforma;

    @ManyToOne
    @JoinColumn(name = "ideditora")
    private Editoras editora;

    @ManyToOne
    @JoinColumn(name = "iddistribuidora")
    private Distribuidoras distribuidora;
}
