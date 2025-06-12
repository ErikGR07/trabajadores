package com.example.trabajadores.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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