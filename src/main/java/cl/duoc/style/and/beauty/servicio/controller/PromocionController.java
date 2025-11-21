package cl.duoc.style.and.beauty.servicio.controller;

import cl.duoc.style.and.beauty.servicio.model.Promocion;
import cl.duoc.style.and.beauty.servicio.repository.PromocionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promociones")
@CrossOrigin(origins = "*")
public class PromocionController {

    private final PromocionRepository promocionRepository;

    public PromocionController(PromocionRepository promocionRepository) {
        this.promocionRepository = promocionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Promocion>> listarPromociones() {
        return ResponseEntity.ok(promocionRepository.findAll());
    }

    @GetMapping("/activas")
    public ResponseEntity<List<Promocion>> listarActivas() {
        return ResponseEntity.ok(
                promocionRepository.findAll()
                        .stream()
                        .filter(p -> p.getActiva().equalsIgnoreCase("S"))
                        .toList()
        );
    }

    @PostMapping
    public ResponseEntity<Promocion> crearPromocion(@RequestBody Promocion promocion) {
        return ResponseEntity.ok(promocionRepository.save(promocion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPromocion(@PathVariable Long id) {
        promocionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
