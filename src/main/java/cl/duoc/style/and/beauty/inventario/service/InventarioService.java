package cl.duoc.style.and.beauty.inventario.service;

import cl.duoc.style.and.beauty.inventario.dto.InventarioDTO;
import cl.duoc.style.and.beauty.inventario.dto.InventarioRequestDTO;
import cl.duoc.style.and.beauty.inventario.model.Inventario;
import cl.duoc.style.and.beauty.inventario.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventarioService {

    private final InventarioRepository repository;

    public InventarioService(InventarioRepository repository) {
        this.repository = repository;
    }

    private InventarioDTO toDTO(Inventario inv) {
        InventarioDTO dto = new InventarioDTO();

        dto.setId(inv.getId());
        dto.setProductoId(inv.getProductoId());
        dto.setCantidadDisponible(inv.getCantidadDisponible());
        dto.setFechaActualizacion(inv.getFechaActualizacion());
        return dto;
    }

    public List<InventarioDTO> findAll() {
        return repository.findAll()
                .stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    public InventarioDTO findById(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public InventarioDTO save(InventarioRequestDTO dto) {
        Inventario inv = new Inventario();

        inv.setProductoID(dto.getProductoId());
        inv.setCantidadDisponible(dto.getCantidadDisponible());

        return toDTO(repository.save(inv));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
