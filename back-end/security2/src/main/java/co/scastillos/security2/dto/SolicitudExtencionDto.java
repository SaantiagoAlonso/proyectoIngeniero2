package co.scastillos.security2.dto;

import java.util.Date;

public record SolicitudExtencionDto(Integer n_habitacion,
                                    String nombre,
                                    Date fechaSaidaOriginal,
                                    Date nuevaFechaSalida,
                                    String motivo) {
}
