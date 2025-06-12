package servicio;

import modelo.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.TrabajadorRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorServicio {

        @Autowired
        private TrabajadorRepositorio repository;

        public List<Trabajador> listar() {
            return repository.findAll();
        }

        public Optional<Trabajador> obtener(Long id) {
            return repository.findById(id);
        }

        public Trabajador guardar(Trabajador trabajador) {
            return repository.save(trabajador);
        }

        public void eliminar(Long id) {
            repository.deleteById(id);
        }
    }

