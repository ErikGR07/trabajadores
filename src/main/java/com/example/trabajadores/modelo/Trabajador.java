package com.example.trabajadores.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "trabajador")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", length = 50)
    private String nombres;

    @Column(name = "correo", length = 50)
    private String correo;

    @Column(name = "numeroIdentidad", length = 50)
    private String numeroIdentidad;

    @Column(name = "cargo", length = 50)
    private String cargo;



}