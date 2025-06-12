package com.example.trabajadores.servicio;

import com.example.trabajadores.modelo.Trabajador;

import java.util.List;

public interface TrabajadorServicio {
        List<Trabajador> listar();
        Trabajador obtenerPorId(Long id);
        Trabajador crear(Trabajador trabajador);
        Trabajador actualizar(Long id, Trabajador trabajador);
        void eliminar(Long id);
    }

