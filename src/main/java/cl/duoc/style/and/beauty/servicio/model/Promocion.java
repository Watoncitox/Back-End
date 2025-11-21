package cl.duoc.style.and.beauty.servicio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PROMOCION")
@Getter
@Setter
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROMOCION")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_SERVICIO", nullable = false)
    private Servicio servicio;

    @Column(name = "DESCUENTO", nullable = false)
    private Double descuento;

    @Column(name = "FECHA_INICIO", nullable = false)
    private java.sql.Date fechaInicio;

    @Column(name = "FECHA_FIN", nullable = false)
    private java.sql.Date fechaFin;

    @Column(name = "ACTIVA", nullable = false)
    private String activa;
}
