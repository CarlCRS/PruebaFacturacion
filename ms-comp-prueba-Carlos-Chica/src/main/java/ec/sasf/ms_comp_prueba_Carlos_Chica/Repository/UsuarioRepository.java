package ec.sasf.ms_comp_prueba_Carlos_Chica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(String correo);
    boolean existsByCorreo(String correo);
}
