package cl.duoc.style.and.beauty.inventario.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "INVENTARIO")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INVENTARIO")
    private Long id;

    @Column(name = "ID_PRODUCTO", nullable = false)
    private Long productoId;

    @Column(name = "CANTIDAD_DISPONIBLE", nullable = false)
    private Integer cantidadDisponible;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_ACTUALIZACION", nullable = false)
    private Date fechaActualizacion;

    @PrePersist
    @PreUpdate
    public void preUpdate() {
        this.fechaActualizacion = new Date();
    }

    // Getters y Setters
}
