package cl.duoc.style.and.beauty.usuario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;

    private String nombre;

    private String correo;

    @Column(name = "CONTRASENA")
    private String password;

    @Column(name = "ESTADO")
    private String estado;

    // Relación con ROL
    @ManyToOne
    @JoinColumn(name = "ID_ROL")
    private Rol rol;
}
