package co.scastillos.security2.repository;

import co.scastillos.security2.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoInventario extends JpaRepository<Inventario,Long> {
}
