package cl.duoc.style.and.beauty.usuario.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String correo;
    private String estado;
    private Long rolId;
    private String rolNombre;
}
