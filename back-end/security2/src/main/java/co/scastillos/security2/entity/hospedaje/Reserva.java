package co.scastillos.security2.entity.hospedaje;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserva;

    @OneToMany(mappedBy = "reserva")
    private List<Habitacion> habitaciones;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private Date fechaEntada;

    private Date fechaSalida;

    private Integer n_adultos;

    private Integer n_ninos;

    @ManyToMany
    @JoinTable(
            name = "reserva_servicio",  // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "reserva_id"),  // Clave foránea de Reserva
            inverseJoinColumns = @JoinColumn(name = "servicio_id")  // Clave foránea de ServicioAdicional
    )
    private List<ServicioAdicional> serviciosAdicionales;

}
