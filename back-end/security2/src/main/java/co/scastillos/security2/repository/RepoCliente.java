package co.scastillos.security2.repository;

import co.scastillos.security2.entity.hospedaje.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCliente extends JpaRepository<Cliente,Long> {
}
