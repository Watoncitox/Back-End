package cl.duoc.style.and.beauty.product.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCTO")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PROVEEDOR", nullable = false)
    private Proveedor proveedor;


    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO")
    private Double precio;

    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name = "STOCK_MINIMO")
    private Integer stockMinimo;

}
