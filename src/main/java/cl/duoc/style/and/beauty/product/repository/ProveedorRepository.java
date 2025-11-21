package cl.duoc.style.and.beauty.product.repository;

import cl.duoc.style.and.beauty.product.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
