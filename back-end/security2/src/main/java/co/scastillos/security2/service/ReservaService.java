package co.scastillos.security2.service;

import co.scastillos.security2.dto.DatosReservaDto;
import co.scastillos.security2.dto.SolicitudExtencionDto;
import co.scastillos.security2.entity.hospedaje.Habitacion;
import co.scastillos.security2.entity.hospedaje.Reserva;
import co.scastillos.security2.repository.RepoHabitacion;
import co.scastillos.security2.repository.RepoReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservaService {
    
    @Autowired
    RepoHabitacion repoHabitacion;
    
    @Autowired
    RepoReserva repoReserva;


    public Boolean verificarDisponibilidad(DatosReservaDto reservaDto) {

       Habitacion habitacion = repoHabitacion.findByTipoHabitacion(reservaDto.tipoHabitacion());

       if(habitacion.getEstado()){
           return true;
       }
       return false;

    }

//    public Boolean solicitudExtencion(SolicitudExtencionDto solicitud) {
//
//        Date fechaOriginal = solicitud.fechaSaidaOriginal();
//        Date nuevaFecha = new Date(fechaOriginal.getTime());  // Crear una copia de la fecha original
//        nuevaFecha.setTime(fechaOriginal.getTime() + (24 * 60 * 60 * 1000));  // Sumar 1 día en milisegundos
////        Reserva reserva =  repoReserva.findByNumeroHabitacionAndFechaSalida(
////                solicitud.n_habitacion(), nuevaFecha).orElse(null);
//
//        List<Reserva> reservas = repoReserva.findReservasByFechaEntadaBetween(nuevaFecha, solicitud.nuevaFechaSalida());
//
////        System.out.println(reservas);
//
//
//        if (reservas == null){
//            return true;
//        }
//
//        return false;
//
//
//    }


    public Boolean solicitudExtencion(SolicitudExtencionDto solicitud) {
        Date fechaOriginal = solicitud.fechaSaidaOriginal();
        Date nuevaFecha = new Date(fechaOriginal.getTime());
        nuevaFecha.setTime(fechaOriginal.getTime() + (24 * 60 * 60 * 1000));

        List<Reserva> reservas = repoReserva.findReservasByFechaEntadaBetween(solicitud.fechaSaidaOriginal(), solicitud.nuevaFechaSalida());

        System.out.println("Reservas encontradas: " + reservas.size());
        System.out.println("Nueva fecha: " + nuevaFecha);
        System.out.println("Nueva fecha de salida: " + solicitud.nuevaFechaSalida());

        // Verifica si no hay reservas en el rango
        if (reservas.isEmpty()) {
            return true;
        }

        for (Reserva reserva : reservas) {
            Long idReserva = reserva.getId_reserva(); // Acceder al id_reserva
            System.out.println("ID Reserva: " + idReserva);
            Habitacion habOcupada =  repoHabitacion.findByReserva(reserva);
            if(habOcupada.getN_habitacion() == solicitud.n_habitacion()){
                return false;
            }

        }

        return true;
    }
}


