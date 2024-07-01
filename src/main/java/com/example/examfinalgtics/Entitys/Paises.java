package com.example.examfinalgtics.Entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "paises")
public class Paises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpais" , nullable = false)
    private Integer idPais;

    @Column(name = "iso",length = 2)
    private String iso;

    @Column(name = "nombre",length = 80)
    private String nombre;
}
