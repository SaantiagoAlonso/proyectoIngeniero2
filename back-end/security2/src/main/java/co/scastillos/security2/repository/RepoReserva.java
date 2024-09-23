package co.scastillos.security2.repository;

import co.scastillos.security2.entity.hospedaje.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepoReserva extends JpaRepository<Reserva,Long> {

    @Query("SELECT r FROM Reserva r JOIN r.habitaciones h WHERE h.n_habitacion = :nHabitacion AND r.fechaSalida = :fechaSalidaMinus1")
    Optional<Reserva> findByNumeroHabitacionAndFechaSalida(@Param("nHabitacion") Integer nHabitacion,
                                                              @Param("fechaSalidaMinus1") Date fechaSalidaMinus1);

//    @Query("SELECT r FROM Reserva r WHERE r.fechaEntada >= :startDate AND r.fechaEntada <= :endDate")
//    List<Reserva> findReservasByFechaEntadaBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT * FROM reservas WHERE fecha_entada >= :startDate AND fecha_entada <= :endDate", nativeQuery = true)
    List<Reserva> findReservasByFechaEntadaBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);



}
