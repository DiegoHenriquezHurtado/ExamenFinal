package com.example.examfinalgtics.Entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "distribuidoras")
public class Distribuidoras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddistribuidora" , nullable = false)
    private Integer idDistribuidora;

    @Column(name = "nombre",length = 50)
    private String nombre;

    @Column(name = "descripcion",length = 448)
    private String descripcion;

    @Column(name = "fundacion",nullable = false)
    private int fundacion;

    @Column(name = "web",length = 200)
    private String web;

    @ManyToOne
    @JoinColumn(name = "idsede")
    private Paises sede;
}
