package cl.duoc.style.and.beauty.usuario.repository;

import cl.duoc.style.and.beauty.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
