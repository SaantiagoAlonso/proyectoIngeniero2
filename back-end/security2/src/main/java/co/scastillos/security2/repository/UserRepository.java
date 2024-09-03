package co.scastillos.security2.repository;

import co.scastillos.security2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario,Long> {

    Usuario findByUsername(String username);

    Optional<Usuario> findByEmail (String email); // agregado2

}
