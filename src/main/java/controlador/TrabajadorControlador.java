package controlador;

import modelo.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicio.TrabajadorServicio;

import java.util.List;

@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadorControlador {

    @Autowired
    private TrabajadorServicio service;

    @GetMapping
    public List<Trabajador> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> obtener(@PathVariable Long id) {
        return service.obtener(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Trabajador crear(@RequestBody Trabajador trabajador) {
        return service.guardar(trabajador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> actualizar(@PathVariable Long id, @RequestBody Trabajador trabajador) {
        return service.obtener(id)
                .map(actual -> {
                    trabajador.setId(id);
                    return ResponseEntity.ok(service.guardar(trabajador));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.obtener(id)
                .map(t -> {
                    service.eliminar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
