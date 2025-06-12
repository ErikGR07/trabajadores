package com.example.trabajadores.repositorio;

import com.example.trabajadores.modelo.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepositorio extends JpaRepository<Trabajador, Long> {
}


