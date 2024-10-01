package co.scastillos.security2.repository;

import co.scastillos.security2.entity.hospedaje.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPedido extends JpaRepository<Pedido,Long> {
}
