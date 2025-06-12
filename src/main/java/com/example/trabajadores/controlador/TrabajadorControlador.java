package com.example.trabajadores.controlador;

import com.example.trabajadores.modelo.Trabajador;
import com.example.trabajadores.servicio.TrabajadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadorControlador {

    @Autowired
    private TrabajadorServicio servicio;

    @GetMapping
    public List<Trabajador> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(servicio.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Trabajador> crear(@RequestBody Trabajador trabajador) {
        return ResponseEntity.ok(servicio.crear(trabajador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> actualizar(@PathVariable Long id, @RequestBody Trabajador trabajador) {
        return ResponseEntity.ok(servicio.actualizar(id, trabajador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}