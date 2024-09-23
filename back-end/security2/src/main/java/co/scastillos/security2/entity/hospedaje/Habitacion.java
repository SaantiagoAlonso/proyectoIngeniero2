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
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_habitacion;

    private Integer n_habitacion;

    private String tipoHabitacion;

    private Double precio;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "reserva_id")  // Clave foránea para la relación con Reserva
    private Reserva reserva;

}
