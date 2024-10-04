package co.scastillos.security2.entity.hospedaje;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "cuentaHabitacion")
public class CuentaHabitacion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer n_habitacion;

    private Integer identificacionCliente;

    private String nombreCliente;

    private Double costoDesayuno;

    private Double costoAlmuerzo;

    private Double costoExtra;

    private Double costoTotal;

}
