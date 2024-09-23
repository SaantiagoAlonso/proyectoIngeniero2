package co.scastillos.security2.repository;

import co.scastillos.security2.entity.hospedaje.Habitacion;
import co.scastillos.security2.entity.hospedaje.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoHabitacion extends JpaRepository<Habitacion,Long> {
    Habitacion findByTipoHabitacion(String tipoHab);

    Habitacion findByReserva(Reserva reserva);
}
