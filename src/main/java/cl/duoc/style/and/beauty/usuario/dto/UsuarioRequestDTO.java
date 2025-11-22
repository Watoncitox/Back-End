package cl.duoc.style.and.beauty.usuario.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequestDTO {
    private String nombre;
    private String correo;
    private String password;
    private Long rolId;
}
