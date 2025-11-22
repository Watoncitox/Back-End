package cl.duoc.style.and.beauty.usuario.service;

import cl.duoc.style.and.beauty.usuario.dto.UsuarioDTO;
import cl.duoc.style.and.beauty.usuario.dto.UsuarioRequestDTO;
import cl.duoc.style.and.beauty.usuario.model.Usuario;
import cl.duoc.style.and.beauty.usuario.repository.RolRepository;
import cl.duoc.style.and.beauty.usuario.repository.UsuarioRepository;
import cl.duoc.style.and.beauty.usuario.model.Rol;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    private UsuarioDTO toDTO(Usuario u) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(u.getId());
        dto.setNombre(u.getNombre());
        dto.setCorreo(u.getCorreo());
        dto.setEstado(u.getEstado());
        dto.setRolId(u.getRol().getId());
        dto.setRolNombre(u.getRol().getNombre());
        return dto;
    }

    public UsuarioDTO save(UsuarioRequestDTO dto) {

        Rol rol = rolRepository.findById(dto.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Usuario u = new Usuario();
        u.setNombre(dto.getNombre());
        u.setCorreo(dto.getCorreo());
        u.setPassword(dto.getPassword());
        u.setEstado("ACTIVO");
        u.setRol(rol);

        return toDTO(usuarioRepository.save(u));
    }

    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO findById(Long id) {
        return usuarioRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }
}
