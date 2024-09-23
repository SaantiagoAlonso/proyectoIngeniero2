package co.scastillos.security2.entity.hospedaje;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pago;

//    private Reserva reserva;

    private Double monto;

    private String metodoPago;

    private Date fechaPago;

}
