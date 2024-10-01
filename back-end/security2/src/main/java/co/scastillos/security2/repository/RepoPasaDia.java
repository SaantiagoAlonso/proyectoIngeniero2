package co.scastillos.security2.repository;

import co.scastillos.security2.entity.PasaDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPasaDia extends JpaRepository<PasaDia,Long> {
}
