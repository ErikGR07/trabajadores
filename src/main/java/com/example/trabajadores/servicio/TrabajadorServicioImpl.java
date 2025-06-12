package com.example.trabajadores.servicio;

import com.example.trabajadores.modelo.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.trabajadores.repositorio.TrabajadorRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorServicioImpl implements TrabajadorServicio {

    @Autowired
    private TrabajadorRepositorio repositorio;

    @Override
    public List<Trabajador> listar() {
        return repositorio.findAll();
    }

    @Override
    public Trabajador obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));
    }

    @Override
    public Trabajador crear(Trabajador trabajador) {
        return repositorio.save(trabajador);
    }

    @Override
    public Trabajador actualizar(Long id, Trabajador datosActualizados) {
        Trabajador existente = obtenerPorId(id);
        existente.setNombres(datosActualizados.getNombres());
        existente.setCorreo(datosActualizados.getCorreo());
        existente.setNumeroIdentidad(datosActualizados.getNumeroIdentidad());
        existente.setCargo(datosActualizados.getCargo());
        return repositorio.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Trabajador existente = obtenerPorId(id);
        repositorio.delete(existente);
    }
}

