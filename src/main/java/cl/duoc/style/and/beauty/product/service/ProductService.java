package cl.duoc.style.and.beauty.product.service;

import cl.duoc.style.and.beauty.product.dto.ProductDTO;
import cl.duoc.style.and.beauty.product.dto.ProductRequestDTO;
import cl.duoc.style.and.beauty.product.model.Proveedor;
import cl.duoc.style.and.beauty.product.model.Product;
import cl.duoc.style.and.beauty.product.repository.ProductRepository;
import cl.duoc.style.and.beauty.product.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProveedorRepository proveedorRepository;

    public ProductService(ProductRepository productRepository,
                          ProveedorRepository proveedorRepository) {
        this.productRepository = productRepository;
        this.proveedorRepository = proveedorRepository;
    }

    // Convertir entity -> DTO
    private ProductDTO toDTO(Product p) {
        ProductDTO dto = new ProductDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setDescripcion(p.getDescripcion());
        dto.setPrecio(p.getPrecio());
        dto.setCategoria(p.getCategoria());
        dto.setStockMinimo(p.getStockMinimo());

        dto.setProveedorId(p.getProveedor().getId());
        dto.setProveedorNombre(p.getProveedor().getNombre());

        return dto;
    }

    // GET ALL
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public ProductDTO findById(Long id) {
        return productRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    // SAVE PRODUCT
    public ProductDTO save(ProductRequestDTO dto) {
        Proveedor proveedor = proveedorRepository.findById(dto.getProveedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        Product p = new Product();
        p.setProveedor(proveedor);
        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setPrecio(dto.getPrecio());
        p.setCategoria(dto.getCategoria());
        p.setStockMinimo(dto.getStockMinimo());

        Product saved = productRepository.save(p);
        return toDTO(saved);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
