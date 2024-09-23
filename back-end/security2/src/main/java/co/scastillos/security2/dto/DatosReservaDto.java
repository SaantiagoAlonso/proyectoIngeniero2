package co.scastillos.security2.dto;

import co.scastillos.security2.entity.hospedaje.Cliente;
import co.scastillos.security2.entity.hospedaje.Habitacion;

import java.util.Date;

public record DatosReservaDto(Cliente cliente,
                              Date fechaEntrada,
                              Date fechaSalida,
                              Integer n_adultos ,
                              Integer n_ninos,
                              String tipoHabitacion) {
}
